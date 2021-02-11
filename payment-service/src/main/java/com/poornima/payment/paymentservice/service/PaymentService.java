package com.poornima.payment.paymentservice.service;

import com.poornima.commons.model.payment.Payment;

public interface PaymentService {
    Payment save(Payment payment);

    Payment fetchByOrderId(int orderId);
}
