package com.poornima.order.orderservice.repository;

import com.poornima.commons.model.order.OrderDetail;
import com.poornima.commons.model.order.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
}
