package com.example.validateexercise.service;

import com.example.validateexercise.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    Page<User>findAll(Pageable pageable);

    void create(User user);
}
