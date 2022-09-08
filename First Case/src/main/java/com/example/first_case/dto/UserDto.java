package com.example.first_case.dto;

import com.example.first_case.model.product;
import com.example.first_case.model.productComment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@NoArgsConstructor
@ToString
public class UserDto {

    private String user_name;
    private String user_surname;
    private String user_email;
    private Integer user_number;

    public UserDto(String user_name, String user_surname, String user_email, Integer user_number) {
        this.user_name = user_name;
        this.user_surname = user_surname;
        this.user_email = user_email;
        this.user_number = user_number;
    }
}
