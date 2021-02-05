package com.poornima.product.productservice.repository;

import com.poornima.commons.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {

}
