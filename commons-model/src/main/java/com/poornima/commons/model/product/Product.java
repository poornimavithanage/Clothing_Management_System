package com.poornima.commons.model.product;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    private String code;
    private String description;
    private String size;
    private BigDecimal unitPrice;
    private int qtyOnHand;
}
