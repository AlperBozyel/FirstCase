package com.example.first_case.dto.converter;

import com.example.first_case.dto.UserDto;
import com.example.first_case.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    private String user_name;
    private String user_surname;
    private String user_email;
    private Integer user_number;

    @Autowired
    private final ProductCommentDtoConverter productCommentDtoConverter;

    public UserDtoConverter(ProductCommentDtoConverter productCommentDtoConverter) {
        this.productCommentDtoConverter = productCommentDtoConverter;
    }

    public UserDto convertToProduct(user from){
        if(from == null){
            return new UserDto("","","",null);
        }
        return null;
    }

}
