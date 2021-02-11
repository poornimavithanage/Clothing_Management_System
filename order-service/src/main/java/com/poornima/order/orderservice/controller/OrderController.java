package com.poornima.order.orderservice.controller;

import com.poornima.commons.model.order.Order;
import com.poornima.order.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("services/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public Order save(@RequestBody Order order){
       return orderService.save(order);
    }


}
