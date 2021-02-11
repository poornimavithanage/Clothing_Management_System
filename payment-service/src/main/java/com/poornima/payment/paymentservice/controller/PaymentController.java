package com.poornima.payment.paymentservice.controller;

import com.poornima.commons.model.payment.Payment;
import com.poornima.payment.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services/payments")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping
    public Payment save(@RequestBody Payment payment){
    return paymentService.save(payment);
    }

    @GetMapping(value = "{/id}")
    public Payment fetchByOrderId(@PathVariable int id){
        return paymentService.fetchByOrderId(id);
    }
}
