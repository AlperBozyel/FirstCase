package com.example.first_case.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "urunYorum")
public class productComment {

    @Id
    @GeneratedValue( generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "Id", nullable = false)
    private Long comment_id;

    @Column(name = "Yorum", length = 500, nullable = false)
    private String comment;

    @Column(name = "yorumTarihi", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date comment_date;

    @Column(name = "urunId", nullable = false)
    private Long product_id;

    @Column(name = "kullanıcıId", nullable = false)
    private Long user_id;

    @ManyToOne(
            targetEntity = com.example.first_case.model.user.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "User_fk", referencedColumnName = "user_id")
    private user user;

    @ManyToOne(
            targetEntity = com.example.first_case.model.product.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "Product_fk", referencedColumnName = "product_id")
    private product product;

    public  productComment(){}

    public productComment(Long comment_id, String comment, Date comment_date, Long product_id, Long user_id,
                          user user, product product) {
        this.comment_id = comment_id;
        this.comment = comment;
        this.comment_date = comment_date;
        this.product_id = product_id;
        this.user_id = user_id;
        this.user = user;
        this.product = product;
    }

    //Constructor: Without id
    public productComment(String comment, Date comment_date, Long product_id, Long user_id,
                          user user, product product) {
        this.comment = comment;
        this.comment_date = comment_date;
        this.product_id = product_id;
        this.user_id = user_id;
        this.user = user;
        this.product = product;
    }

    //GETTER - SETTER
    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }


    @Override
    public String toString() {
        return "productComment{" +
                "comment_id=" + comment_id +
                ", comment='" + comment + '\'' +
                ", comment_date=" + comment_date +
                ", product_id=" + product_id +
                ", user_id=" + user_id +
                ", user=" + user +
                ", product=" + product +
                '}';
    }
}
