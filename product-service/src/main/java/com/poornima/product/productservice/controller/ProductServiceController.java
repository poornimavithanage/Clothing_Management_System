package com.poornima.product.productservice.controller;

import com.poornima.commons.model.product.Product;
import com.poornima.product.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("services/product-management/products")
public class ProductServiceController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping(value = "{/code}")
    public Product getProduct(@PathVariable String code){
        System.out.println("request came on " + LocalDateTime.now() + " 3 ++++++++++++++++++++++");
        return productService.findById(code);
    }

    @GetMapping
    public List<Product>getAllProducts(){
    return productService.findAll();
    }

}
