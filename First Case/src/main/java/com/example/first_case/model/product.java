package com.example.first_case.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Urun")
public class product {

    @Id
    @GeneratedValue( generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "Id", nullable = false)
    private Long product_id;

    @Column(name = "Adı",nullable = false)
    private String product_name;

    @Column(name = "Fiyat", nullable = false)
    private Double product_price;

    @Column(name = "Son Kullanma Tarihi", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date expiration_date;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    private Set<productComment> productComments = new HashSet<>();

    public product(){}

    public product(Long product_id, String product_name, Double product_price,
                   Date expiration_date, Set<productComment> productComments) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.expiration_date = expiration_date;
        this.productComments = productComments;
    }

    // Constructor: Without id
    public product(String product_name, Double product_price,
                   Date expiration_date, Set<productComment> productComments) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.expiration_date = expiration_date;
        this.productComments = productComments;
    }

    //GETTER - SETTER
    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long id) {
        this.product_id = product_id;
    }


    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    @Override
    public String toString() {
        return "product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                ", expiration_date=" + expiration_date +
                ", productComments=" + productComments +
                '}';
    }

}
