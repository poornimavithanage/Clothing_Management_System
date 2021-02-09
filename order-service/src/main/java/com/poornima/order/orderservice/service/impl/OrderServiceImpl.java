package com.poornima.order.orderservice.service.impl;


import com.poornima.commons.model.order.Order;

import com.poornima.order.orderservice.repository.OrderRepository;
import com.poornima.order.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Component
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

   /* @Transactional(readOnly = true)
    @Override
    public String getNewOrderId() throws Exception {

        String lastOrderId = orderRepository.getOrderIdByDesc().getOrderId();

        if (lastOrderId == null) {
            return "OD001";
        } else {
            int maxId = Integer.parseInt(lastOrderId.replace("OD", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "OD00" + maxId;
            } else if (maxId < 100) {
                id = "OD0" + maxId;
            } else {
                id = "OD" + maxId;
            }
            return id;
        }
    }*/
}
