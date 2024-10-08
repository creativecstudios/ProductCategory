package org.ccs.productcategoryservice.controllers;

import org.ccs.productcategoryservice.dto.CategoryDto;
import org.ccs.productcategoryservice.dto.ProductDto;
import org.ccs.productcategoryservice.exceptions.ProductNotFoundException;
import org.ccs.productcategoryservice.models.Product;
import org.ccs.productcategoryservice.service.ProductServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Qualifier("selfProductService")
    @Autowired
    ProductServiceProvider productServiceProvider;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) throws ProductNotFoundException {
//        try{
//            if(productId < 1){
//                throw new RuntimeException("Product not found");
//            }
            Product product = productServiceProvider.getProductById(productId);
            return new ResponseEntity<>(from(product), HttpStatus.OK);
//        }
//        catch (RuntimeException | ProductNotFoundException e){
//            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
//        }
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productServiceProvider.createProduct(product);
    }
    private ProductDto from(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setAmount(product.getAmount());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }

        return productDto;
    }

}
