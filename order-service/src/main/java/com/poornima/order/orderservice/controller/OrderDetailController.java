package com.poornima.order.orderservice.controller;

import com.poornima.commons.model.order.OrderDetail;
import com.poornima.order.orderservice.dto.OrderDetailDTO;
import com.poornima.order.orderservice.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/services/orderDetails")
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;

    @PostMapping
    public ResponseEntity<OrderDetail> save(@RequestBody OrderDetail orderDetail){
        OrderDetail newOrderDetail = orderDetailService.save(orderDetail);
        try {
            return ResponseEntity.ok().body(newOrderDetail);
        } catch (NullPointerException nullPointerException) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(newOrderDetail);
        }
    }

    @GetMapping(value = "/{id}")
    public OrderDetailDTO fetch(@PathVariable(value = "id")int id){
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setOrderDetailList(orderDetailService.findByOrderId(id));
        return orderDetailDTO;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){
        try {
            orderDetailService.delete(id);
            return ResponseEntity.ok().body("Order Detail deleted Successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Detail does not exist");
        }
    }

    @GetMapping()
    public List<OrderDetail>fetchByOrderId(){
        System.out.println("------order details-----------");
        return orderDetailService.findOrderDetail();
    }


}
