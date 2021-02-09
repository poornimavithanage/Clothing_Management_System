package com.poornima.commons.model.order;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "`Order`")
@Data
@NonNull
public class Order  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private String customerId;
    private LocalDateTime date;
    private BigDecimal totalAmount;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

}
