package com.example.bai1.service;

import com.example.bai1.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void create(Blog blog);
    void update(Blog blog);
    void delete(int id );
    Blog findById(int id);
}
