package com.xuantoan.springboot.service.impl;

import com.xuantoan.springboot.entity.UserEntity;
import com.xuantoan.springboot.repository.UserRepository;
import com.xuantoan.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public UserEntity saveOrUpdate(UserEntity user) {

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
