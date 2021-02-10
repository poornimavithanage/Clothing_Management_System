package com.poornima.commons.model.payment;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private int orderId;
    private BigDecimal totalAmount;


}
