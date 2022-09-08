package com.example.first_case.dto.converter;

import com.example.first_case.dto.ProductCommentDto;
import com.example.first_case.dto.ProductDto;
import com.example.first_case.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ProductDtoConverter {

    @Autowired
    private final ProductCommentDtoConverter productCommentDtoConverter;

    private Long product_id;
    private String product_name;
    private Double product_price;
    private Date expiration_date;

    public ProductDtoConverter(ProductCommentDtoConverter productCommentDtoConverter) {
        this.productCommentDtoConverter = productCommentDtoConverter;
    }

    public ProductDto convertToProduct(product from){
        if(from == null){
            return new ProductDto("",null,null);
        }
        return null;
    }

}
