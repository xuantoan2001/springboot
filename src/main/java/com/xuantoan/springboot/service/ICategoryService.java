package com.xuantoan.springboot.service;

import com.xuantoan.springboot.entity.CategoryEntity;

import java.util.List;

public interface ICategoryService {
    List<CategoryEntity> findAll();
    CategoryEntity save(CategoryEntity category);
}
