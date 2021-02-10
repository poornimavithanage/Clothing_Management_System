package com.poornima.order.orderservice.dto;

import com.poornima.commons.model.order.OrderDetail;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetailDTO {
    private List<OrderDetail> orderDetailList;
}
