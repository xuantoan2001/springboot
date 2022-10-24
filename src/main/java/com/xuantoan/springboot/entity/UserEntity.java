package com.xuantoan.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity{

    private String userName;
    @Column(name = "ful_lname")
    private String fullname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "avatar")
    private String avatar;


}
