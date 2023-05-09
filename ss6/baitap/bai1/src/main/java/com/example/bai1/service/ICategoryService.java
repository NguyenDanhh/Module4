package com.example.bai1.service;

import com.example.bai1.model.Blog;
import com.example.bai1.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void create(Category category);
    void update(Category category);
    void delete(int id );
}
