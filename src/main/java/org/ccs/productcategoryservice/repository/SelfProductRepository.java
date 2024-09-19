package org.ccs.productcategoryservice.repository;

import org.ccs.productcategoryservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SelfProductRepository extends JpaRepository<Product,Long> {

    @Override
    Optional<Product> findById(Long id);
}
