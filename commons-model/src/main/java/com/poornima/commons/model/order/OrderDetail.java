package com.poornima.commons.model.order;

import lombok.*;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orderDetail")
@Data
@NonNull
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String productCode;
    private int quantity;
    private BigDecimal unitPrice;
    @ManyToOne
    @JoinColumn
    Order order;

}
