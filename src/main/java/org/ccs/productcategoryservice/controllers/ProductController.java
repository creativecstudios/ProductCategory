package org.ccs.productcategoryservice.controllers;

import org.ccs.productcategoryservice.dto.CategoryDto;
import org.ccs.productcategoryservice.dto.ProductDto;
import org.ccs.productcategoryservice.models.Product;
import org.ccs.productcategoryservice.service.ProductServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductServiceProvider productServiceProvider;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId){
        try{
            if(productId < 1){
                throw new RuntimeException("Product not found");
            }
            Product product = productServiceProvider.getProductById(productId);
            return new ResponseEntity<>(from(product), HttpStatus.OK);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
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
