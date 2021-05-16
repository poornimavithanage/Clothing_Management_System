package com.poornima.order.orderservice.service.impl;

import com.poornima.commons.model.order.OrderDetail;
import com.poornima.commons.model.product.Product;
import com.poornima.order.orderservice.repository.OrderDetailRepository;
import com.poornima.order.orderservice.repository.OrderRepository;
import com.poornima.order.orderservice.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderRepository orderRepository;

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        Product product = restTemplate.getForObject
                ("http://product/services/product-management/products/"
                        +orderDetail.getProductCode(),Product.class);
        orderDetail.setOrderId(orderRepository.findTopByOrderByIdDesc().getId());
        assert product != null;
        BigDecimal unitPrice = product.getUnitPrice();
        orderDetail.setPrice(unitPrice.multiply(BigDecimal.valueOf(orderDetail.getQuantity())));
        System.out.println(orderDetail);
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> findByOrderId(int id){
        return orderDetailRepository.findByOrderId(id);
    }



    @Override
    public List<OrderDetail> findOrderDetail() {
       int id = orderRepository.findTopByOrderByIdDesc().getId();
        return orderDetailRepository.findByOrderId(id);

    }



    @Override
    public void delete(int id) {
        orderDetailRepository.deleteById(id);
    }
}
