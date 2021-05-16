package com.poornima.customer.customerservice.controller;

import com.poornima.commons.model.customer.Customer;
import com.poornima.customer.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("services/customer-management/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerServiceController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public String save(@RequestBody Customer customer){
        customerService.save(customer);
        return "Successfully saved " + customer.getName() ;
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable String id){
        System.out.println("request came on " + LocalDateTime.now() + " 2 ++++++++++++++++++++++");
        return customerService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@RequestBody Customer customer){
        Customer updateCustomer = customerService.update(customer);
        try {
            return ResponseEntity.ok().body(updateCustomer);
        } catch (NullPointerException nullPointerException) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Customer ID does not exist");
        }

    }

    @GetMapping
    public List<Customer>getAllCustomers(){
    return customerService.findAll();
    }

    @GetMapping(value = "/contact/{contact}")
    public ResponseEntity viewCustomer(@PathVariable String contact){
        Customer customer = customerService.findCustomerByContact(contact);
    try {
        return ResponseEntity.ok().body(customer);
    } catch (DuplicateKeyException duplicateKeyException) {
       return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Contact Number could not be duplicated");
    }
}
}
