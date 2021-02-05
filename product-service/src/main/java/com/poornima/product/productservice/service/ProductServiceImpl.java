package com.poornima.product.productservice.service;

import com.poornima.commons.model.product.Product;
import com.poornima.product.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(String code) {
        Optional<Product>product=productRepository.findById(code);
        if(product.isPresent())
            return product.get();
        else
        return new Product();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
