package com.example.first_case.service;


import com.example.first_case.dto.ProductCommentDto;
import com.example.first_case.dto.ProductDto;
import com.example.first_case.model.product;
import com.example.first_case.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class productService {

    private ProductRepo productRepo;


    @Autowired
    public productService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<ProductCommentDto> getProductCommentByProductId(Long product_id)
    {
        List<ProductCommentDto> productComments = productRepo.getProductCommentsByProduct(product_id);
        return productComments;
    }

    public List<ProductCommentDto> getProductCommentsByProductBetweenDateInterval(Long product_id, Date dateStart, Date dateFinal)
    {
        List<ProductCommentDto> productComments = productRepo.getProductCommentsByProductBetweenDateInterval(product_id, dateStart, dateFinal);
        return productComments;
    }

    public List<ProductDto> getFreshProduct()
    {
        List<ProductDto> products = productRepo.getFreshProduct();
        return products;
    }

    public List<ProductDto> getExpiredProduct()
    {
        List<ProductDto> products = productRepo.getExpiredProduct();
        return products;
    }

}
