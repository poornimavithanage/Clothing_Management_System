package com.poornima.order.orderservice.controller;

import com.poornima.commons.model.order.Order;
import com.poornima.order.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("services/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public Order save(@RequestBody Order order){
       return orderService.save(order);
    }

    @GetMapping
    public Order fetch(){
        System.out.println("------order--------");
        return orderService.getOrderRecord();
    }
}
