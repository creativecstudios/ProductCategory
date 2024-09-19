package org.ccs.productcategoryservice.service;

import org.ccs.productcategoryservice.exceptions.ProductNotFoundException;
import org.ccs.productcategoryservice.models.Category;
import org.ccs.productcategoryservice.models.Product;
import org.ccs.productcategoryservice.repository.SelfCategoryRepository;
import org.ccs.productcategoryservice.repository.SelfProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductServiceImplementation implements ProductServiceProvider{

    @Autowired
    private SelfProductRepository productRepository;
    @Autowired
    private SelfCategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException(id,"Product with id not forund");
        }
        return product.get();
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId() == null){
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }

        Product product1 = productRepository.save(product);
        Optional<Category> category1 = categoryRepository.findById(product1.getCategory().getId());
        category1.ifPresent(product1::setCategory);
        return product1;
    }
}
