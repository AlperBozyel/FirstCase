package com.example.first_case.controller;

import com.example.first_case.app.FirstCaseApplication;
import com.example.first_case.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@RestController(value = "/product")
public class productController {

    private productService productService;

    @Autowired
    public productController(productService productService) {
        this.productService = productService;
    }

    @GetMapping("/productComments")
    public ResponseEntity<List> productInfo(@RequestParam Long product_id)
    {
        return ResponseEntity.ok(productService.getProductCommentByProductId(product_id));
    }

    @GetMapping("/productComments/ByDate")
    public ResponseEntity<List> productCommentsByDateInterval(@RequestParam Long product_id, Date dateStart, Date dateFinal)
    {
        return ResponseEntity.ok(productService.getProductCommentsByProductBetweenDateInterval(product_id, dateStart, dateFinal));
    }

    @GetMapping("/FreshProducts")
    public ResponseEntity<List> freshProductInfo(){
        return ResponseEntity.ok(productService.getFreshProduct());
    }

    @GetMapping("/ExpiredProduct")
    public ResponseEntity<List> ExpiredProductInfo()
    {
        return ResponseEntity.ok(productService.getExpiredProduct());
    }

    @RequestMapping(value = "/Hello", method = RequestMethod.GET)
    public String get(){
        return "Hello Spring";
    }

}
