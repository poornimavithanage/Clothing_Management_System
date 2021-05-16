package com.poornima.payment.paymentservice.controller;

import com.poornima.commons.model.payment.Payment;
import com.poornima.payment.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/services/payments")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping
    public Payment save(Payment payment){
    return paymentService.save(payment);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity fetchOrderById(@PathVariable int id){
        Payment payment = paymentService.fetchByOrderId(id);
        try {
            return ResponseEntity.ok(payment);
        } catch (NullPointerException nullPointerException) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Order ID does not exist");

        }
    }
}
