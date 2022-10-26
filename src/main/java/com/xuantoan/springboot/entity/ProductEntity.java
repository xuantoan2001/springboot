package com.xuantoan.springboot.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity{
    @Column(name = "product_name")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "rate")
    private Integer rate;

    @OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Collection<CommentEntity> comments;


    public String getProductName() {
        return productName;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Collection<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Collection<CommentEntity> comments) {
        this.comments = comments;
    }

    public ProductEntity() {
    }
    public ProductEntity(String productName, CategoryEntity category, String description, Double price, String productImage, Long quantity, Integer rate, Collection<CommentEntity> comments) {
        this.productName = productName;
        this.category = category;
        this.description = description;
        this.price = price;
        this.productImage = productImage;
        this.quantity = quantity;
        this.rate = rate;
        this.comments = comments;
    }
}
