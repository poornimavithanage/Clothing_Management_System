package com.poornima.product.productservice.controller;

import com.poornima.commons.model.customer.Customer;
import com.poornima.commons.model.product.Product;
import com.poornima.product.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("services/product-management/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductServiceController {

    @Autowired
    ProductService productService;

    @PostMapping
    public String save(@RequestBody Product product){
         productService.save(product);
        return "Successfully saved " + product.getCode();
    }

    @GetMapping(value = "/{code}")
    public Product getProduct(@PathVariable String code){
        System.out.println("request came on " + LocalDateTime.now() + " 3 ++++++++++++++++++++++");
        return productService.findById(code);
    }

    @GetMapping
    public List<Product>getAllProducts(){
    return productService.findAll();
    }

    @PutMapping(value = "/{code}")
    public ResponseEntity update(@RequestBody Product product){
        Product updateProduct = productService.update(product);
        try {
            return ResponseEntity.ok().body(updateProduct);
        } catch (NullPointerException nullPointerException) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Product Code does not exist");
        }

    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity deleteProduct(@PathVariable String code){
        try {
            productService.delete(code);
            return ResponseEntity.ok().body("Product deleted Successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product code does not exist");
        }
    }

}
