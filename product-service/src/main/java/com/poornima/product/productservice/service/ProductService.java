package com.poornima.product.productservice.service;

import com.poornima.commons.model.product.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    Product findById(String code);

    List<Product>findAll();

    Product update(Product product);

    void delete(String code);

}
