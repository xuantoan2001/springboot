package com.xuantoan.springboot.service;

import com.xuantoan.springboot.entity.ProductEntity;
import java.util.List;

public interface IProductService {

    List<ProductEntity> findAll();
    ProductEntity getProductById(Long id);
    ProductEntity save(ProductEntity product);
    void delete(Long id);
    String ConventProductImg(String conventProductImg);
}
