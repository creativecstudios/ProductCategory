package org.ccs.productcategoryservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception{

    private String message;
    private Long id;
    public ProductNotFoundException(Long id, String message){
        super(message);
        this.setId(id);
    }
}
