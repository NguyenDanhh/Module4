package com.example.validateexercise.service;

import com.example.validateexercise.model.User;
import com.example.validateexercise.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;
    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void create(User user) {
        this.userRepository.save(user);
    }
}
