package com.example.first_case.controller;


import com.example.first_case.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller(value = "/user")
public class userController {

    private userService userService;

    @Autowired
    public userController(userService userService) {
        this.userService = userService;
    }

    @GetMapping("/productComments")
    @ResponseBody
    public ResponseEntity<List> userInfo(@RequestParam Long id)
    {
        return ResponseEntity.ok(userService.getProductCommentByUserId(id));
    }

    @GetMapping("/productComments/ByDate")
    public ResponseEntity<List> productCommentsByDateInterval(@RequestParam Long user_id, Date dateStart, Date dateFinal)
    {
        return ResponseEntity.ok(userService.getProductCommentsByUserBetweenDateInterval(user_id, dateStart, dateFinal));
    }

    @RequestMapping(value = "/Hello", method = RequestMethod.GET)
    public String get(){
        return "Hello Spring";
    }

}
