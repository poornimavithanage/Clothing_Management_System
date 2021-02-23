package com.poornima.order.orderservice.service.impl;


import com.poornima.commons.model.order.Order;

import com.poornima.order.orderservice.repository.OrderRepository;
import com.poornima.order.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }



    @Override
    public Order getRecord() {
        return orderRepository.findTopByOrderByIdDesc();
    }

}
