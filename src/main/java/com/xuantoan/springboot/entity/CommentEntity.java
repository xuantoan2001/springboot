package com.xuantoan.springboot.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="comment")
public class CommentEntity extends BaseEntity{
    @Column(name = "content")
    private String content;
    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CommentEntity(String content, Date createdDate, ProductEntity product, UserEntity user) {
        this.content = content;
        this.createdDate = createdDate;
        this.product = product;
        this.user = user;
    }

    public CommentEntity() {
    }
}
