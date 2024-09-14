package org.ccs.productcategoryservice.service;

import org.ccs.productcategoryservice.models.Product;

import java.util.List;

public interface ProductServiceProvider {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);
}
