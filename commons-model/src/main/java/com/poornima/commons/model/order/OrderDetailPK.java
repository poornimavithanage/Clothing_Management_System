package com.poornima.commons.model.order;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class OrderDetailPK implements Serializable {
    private String orderId;
    private String itemCode;

    public OrderDetailPK(String orderId, String productCode) {
    }

    public OrderDetailPK() {

    }


}
