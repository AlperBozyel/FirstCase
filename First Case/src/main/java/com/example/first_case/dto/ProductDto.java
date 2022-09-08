package com.example.first_case.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString
public class ProductDto implements Serializable {

    private String product_name;
    private Double product_price;
    private Date expiration_date;

    public ProductDto(String product_name, Double product_price, Date expiration_date) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.expiration_date = expiration_date;
    }
}
