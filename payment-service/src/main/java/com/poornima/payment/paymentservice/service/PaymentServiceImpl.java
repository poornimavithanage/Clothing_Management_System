package com.poornima.payment.paymentservice.service;

import com.poornima.commons.model.payment.Payment;
import com.poornima.payment.paymentservice.dto.OrderDetailDTO;
import com.poornima.payment.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
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

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Override
    public Payment save(Payment payment) {
        OrderDetailDTO orderDetailDTO = restTemplate.getForObject("http://services/orderDetails"
                +payment.getOrderId(),OrderDetailDTO.class);
       BigDecimal total = BigDecimal.valueOf(0);
        for (int i = 0; i < Objects.requireNonNull(orderDetailDTO).getOrderDetailList().size(); i++) {
            BigDecimal a = orderDetailDTO.getOrderDetailList().get(i).getPrice();
            BigDecimal.valueOf(0).add(a);
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
