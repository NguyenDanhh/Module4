package com.example.bai1.service;

import com.example.bai1.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();
    Blog create(Blog blog);
    void delete(int id );
    Optional<Blog> findById(int id);

    List<Blog> findByName(String nameCategory);
}
