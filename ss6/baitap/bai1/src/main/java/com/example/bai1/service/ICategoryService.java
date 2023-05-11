package com.example.bai1.service;

import com.example.bai1.model.Blog;
import com.example.bai1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);
    List<Category> findAll();
    void create(Category category);
    void update(Category category);
    void delete(int id );

    Category findById(int id);
}
