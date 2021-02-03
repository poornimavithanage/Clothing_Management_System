package com.poornima.customer.customerservice.repository;

import com.poornima.commons.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
