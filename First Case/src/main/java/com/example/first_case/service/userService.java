package com.example.first_case.service;

import com.example.first_case.dto.ProductCommentDto;
import com.example.first_case.dto.ProductDto;
import com.example.first_case.dto.UserDto;
import com.example.first_case.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class userService {

    private UserRepo userRepo;


    @Autowired
    public userService(UserRepo productRepo) {
        this.userRepo = productRepo;
    }

    public List<ProductCommentDto> getProductCommentByUserId(Long id)
    {
        List<ProductCommentDto> productComments = userRepo.getProductCommentsByUser(id);
        return productComments;
    }

    public List<ProductCommentDto> getProductCommentsByUserBetweenDateInterval(Long user_id, Date dateStart, Date dateFinal)
    {
        List<ProductCommentDto> productComments = userRepo.getProductCommentsByUserBetweenDateInterval(user_id, dateStart, dateFinal);
        return productComments;
    }

}
