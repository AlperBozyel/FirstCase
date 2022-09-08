package com.example.first_case.model;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Kullanıcı")
public class user {
        @Id
        @GeneratedValue( generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        @Column(name = "Id", nullable = false)
        private Long user_id;

        @Column(name = "Adı", length = 50, nullable = false)
        private String user_name;

        @Column(name = "Soyadı", length = 50, nullable = false)
        private String user_surname;

        @Column(name = "Email", length = 50, nullable = false)
        private String user_email;

        @Column(name = "telefon", length = 15, nullable = false)
        private Integer user_number;

        @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
        private Set<productComment> productComments = new HashSet<>();

        public user(){}

        // Constructor: Without id
        public user(String user_name, String user_surname, String user_email, Integer user_number){
                this.user_name = user_name;
                this.user_surname = user_surname;
                this.user_email = user_email;
                this.user_number = user_number;
                this.productComments = productComments;
        }

        public user(Long user_id, String user_name, String user_surname, String user_email,
                    Integer user_number, Set<productComment> productComments) {
                this.user_id = user_id;
                this.user_name = user_name;
                this.user_surname = user_surname;
                this.user_email = user_email;
                this.user_number = user_number;
                this.productComments = productComments;
        }

        //GETTER - SETTER
        public Long getId() {
            return user_id;
        }

        public void setId(Long id) {
            this.user_id = user_id;
        }

        public String getEmail(String s) {
            return user_email;
        }

        public void setEmail(String email) {
            this.user_email = user_email;
        }

        public String getName(String alper) {
            return user_name;
        }

        public void setName(String name) {
            this.user_name = user_name;
        }

        public String getSurname(String bozyel) {
            return user_surname;
        }

        public void setSurname(String surname) {
            this.user_surname = user_surname;
        }

        public Integer getNumber(int i) {
            return user_number;
        }

        public void setNumber(Integer number) {
            this.user_number = user_number;
        }

        @Override
        public String toString() {
                return "user{" +
                        "user_id=" + user_id +
                        ", user_name='" + user_name + '\'' +
                        ", user_surname='" + user_surname + '\'' +
                        ", user_email='" + user_email + '\'' +
                        ", user_number=" + user_number +
                        ", productComments=" + productComments +
                        '}';
        }
}
