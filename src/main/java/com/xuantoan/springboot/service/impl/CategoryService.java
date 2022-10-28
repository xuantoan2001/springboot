package com.xuantoan.springboot.service.impl;

import com.xuantoan.springboot.entity.CategoryEntity;
import com.xuantoan.springboot.repository.CategoryRepository;
import com.xuantoan.springboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity save(CategoryEntity category) {
        return categoryRepository.save(category);
    }
}
