package com.poornima.order.orderservice.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.poornima.commons.model.product.Product;

import org.springframework.web.client.RestTemplate;


public class ProductCommand extends HystrixCommand<Product> {


    RestTemplate restTemplate;
    String productCode;


    public ProductCommand(RestTemplate restTemplate, String productCode) {

        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.restTemplate = restTemplate;
        this.productCode = productCode;
    }


    @Override
    protected Product run() throws Exception {
        return restTemplate.getForObject("http://vehicle/services/vehicles/" + vehicleId, Vehicle.class);
    }

    @Override
    protected Vehicle getFallback() {
        System.out.println("hit on fallback");
        return new Vehicle();
    }
}
