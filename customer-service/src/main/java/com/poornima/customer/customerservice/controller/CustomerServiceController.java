package com.poornima.customer.customerservice.controller;

import com.poornima.commons.model.customer.Customer;
import com.poornima.customer.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("services/customer-management/customers")
public class CustomerServiceController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer save(@RequestBody Customer customer){
    return customerService.save(customer);
    }

    @GetMapping(value = "{/id}")
    public Customer getCustomer(@PathVariable String id){
        System.out.println("request came on " + LocalDateTime.now() + " 2 ++++++++++++++++++++++");
    return customerService.findById(id);
    }

    @GetMapping
    public List<Customer>getAllCustomers(){
    return customerService.findAll();
    }


}
