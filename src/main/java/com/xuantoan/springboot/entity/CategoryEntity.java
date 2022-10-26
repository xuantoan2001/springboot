package com.xuantoan.springboot.entity;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity{

    @Column(name = "category_name")
    private String categoryName;


    @OneToMany(mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Collection<ProductEntity> products;


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryEntity(String categoryName) {
        this.categoryName = categoryName;
    }

    public Collection<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Collection<ProductEntity> products) {
        this.products = products;
    }

    public CategoryEntity() {
    }

    public CategoryEntity(String categoryName, Collection<ProductEntity> products) {
        this.categoryName = categoryName;
        this.products = products;
    }
}
