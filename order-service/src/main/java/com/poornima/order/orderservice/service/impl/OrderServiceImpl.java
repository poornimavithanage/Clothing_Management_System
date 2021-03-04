package com.poornima.order.orderservice.service.impl;


import com.poornima.commons.model.order.Order;

import com.poornima.order.orderservice.repository.OrderRepository;
import com.poornima.order.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date date = new Date();
        order.setDate((dateFormat.format(date)));
        return orderRepository.save(order);
    }



    @Override
    public Order getRecord() {
        return orderRepository.findTopByOrderByIdDesc();
    }

}
