package org.ccs.productcategoryservice.repository;

import org.ccs.productcategoryservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelfCategoryRepository extends JpaRepository<Category,Long> {

    Category save(Category category);
}
