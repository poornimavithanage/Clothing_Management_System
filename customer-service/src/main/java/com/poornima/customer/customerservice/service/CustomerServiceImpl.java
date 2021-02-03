package com.poornima.customer.customerservice.service;

import com.poornima.commons.model.customer.Customer;
import com.poornima.customer.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(String id) {
        Optional<Customer>customer = customerRepository.findById(id);
        if(customer.isPresent())
        return customer.get();
        else
            return new Customer();
    }



    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
