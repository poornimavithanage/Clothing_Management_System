package com.poornima.order.orderservice.service;

import com.poornima.commons.model.order.Order;


public interface OrderService {

Order save(Order order);

Order getOrderRecord();

}
