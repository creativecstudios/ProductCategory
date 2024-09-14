package org.ccs.productcategoryservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.ccs.productcategoryservice.models.Category;

@Getter
@Setter
public class ProductDto {
    private Long id;

    private String title;

    private String description;

    private String imageUrl;

    private Double amount;

    private CategoryDto category;

    private Boolean isPrimeSpecific;
}
