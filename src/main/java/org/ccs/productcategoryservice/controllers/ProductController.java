package org.ccs.productcategoryservice.controllers;

import org.ccs.productcategoryservice.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long productId){
        Product product = new Product();
        product.setId(productId);
        product.setAmount(499D);
        product.setTitle("Budha Resting on Knee");
        return product;
    }
}
