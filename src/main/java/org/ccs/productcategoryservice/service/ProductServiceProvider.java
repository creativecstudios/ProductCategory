package org.ccs.productcategoryservice.service;

import org.ccs.productcategoryservice.exceptions.ProductNotFoundException;
import org.ccs.productcategoryservice.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceProvider {

    List<Product> getAllProducts();

  Product getProductById(Long id) throws ProductNotFoundException;

    Product createProduct(Product product);
}
