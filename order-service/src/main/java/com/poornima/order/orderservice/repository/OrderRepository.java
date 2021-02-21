package com.poornima.order.orderservice.repository;

import com.poornima.commons.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order findOrderByIdDesc();
}
