package org.ccs.productcategoryservice.service;

import org.ccs.productcategoryservice.dto.FakeStoreProductDto;
import org.ccs.productcategoryservice.exceptions.ProductNotFoundException;
import org.ccs.productcategoryservice.models.Category;
import org.ccs.productcategoryservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductServiceProvider{

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate
                .getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();
        if(fakeStoreProductDtoResponseEntity.getStatusCode().equals(HttpStatusCode.valueOf(200)) &&
                fakeStoreProductDto != null){
                return from(fakeStoreProductDto);
        }
        else if(fakeStoreProductDto == null){
            throw new ProductNotFoundException(id,"Product with id "+id+" not fount");
        }
        return from(fakeStoreProductDto);
    }

    @Override
    public Product createProduct(Product product) {
        return product;
    }

    private Product from(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setAmount(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}
