package com.poornima.order.orderservice.service;

import com.poornima.commons.model.order.OrderDetail;

import java.util.List;

public interface OrderDetailService {


    OrderDetail save(OrderDetail orderDetail);

    OrderDetail delete(int id);

    List<OrderDetail> findByOrderId(int id);

    List<OrderDetail> findOrderDetail();
}
