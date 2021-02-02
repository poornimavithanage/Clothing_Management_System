package com.poornima.commons.model.payment;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Payment {
    @Id
    private String id;
    private String customerId;
    private String orderId;
    private String paymentMode;
    private BigDecimal amount;
    LocalDateTime date;
    private String status;


}
