package com.poornima.payment.paymentservice.service;

import com.poornima.commons.model.order.Order;
import com.poornima.commons.model.order.OrderDetail;
import com.poornima.commons.model.payment.Payment;
import com.poornima.payment.paymentservice.dto.OrderDetailDTO;
import com.poornima.payment.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    RestTemplate restTemplate;

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Override
    public Payment save(Payment payment) {
        Order getOrderId = restTemplate.getForObject("http://order/services/orders",Order.class);
        payment.setOrderId(getOrderId.getId());
        OrderDetailDTO orderDetailDTO = restTemplate.getForObject("http://order/services/orderDetails"+ payment.getOrderId(), OrderDetailDTO.class);
        BigDecimal total = new BigDecimal("0.00");
        for (int listSize =0; listSize < orderDetailDTO.getOrderDetailList().size(); listSize++){
            BigDecimal totalOfOrderDetail = orderDetailDTO.getOrderDetailList().get(listSize).getPrice();
            total = totalOfOrderDetail.add(total);
        }

        payment.setTotalAmount(total);
        System.out.println(total);
        System.out.println(orderDetailDTO);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment fetchByOrderId(int orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
