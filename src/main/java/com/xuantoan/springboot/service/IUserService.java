package com.xuantoan.springboot.service;

import com.xuantoan.springboot.entity.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserEntity> findAll();
    UserEntity getUserById(Long id);
    UserEntity saveOrUpdate(UserEntity user);
    void deleteUser(Long id);
}
