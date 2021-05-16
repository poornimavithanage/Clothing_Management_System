package com.poornima.customer.customerservice.service;

import com.poornima.commons.model.customer.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);

    Customer findById(String id);

    List<Customer>findAll();

    Customer update(Customer customer);

    Customer findCustomerByContact(String contact);
}
