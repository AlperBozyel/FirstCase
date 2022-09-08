package com.example.first_case.dto.converter;

import com.example.first_case.dto.ProductCommentDto;
import com.example.first_case.model.productComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Date;

@Component
public class ProductCommentDtoConverter {

    private String comment;
    private Date comment_date;

    @Autowired
    private final ProductDtoConverter productDtoConverter;

    @Autowired
    private final UserDtoConverter userDtoConverter;

    public ProductCommentDtoConverter(ProductDtoConverter productDtoConverter, UserDtoConverter userDtoConverter) {
        this.productDtoConverter = productDtoConverter;
        this.userDtoConverter = userDtoConverter;
    }

    public ProductCommentDto convertToProductComment(productComment from){
        if(from == null){
            return new ProductCommentDto("",null);
        }
        return null;
    }

}
