package com.example.bai1.service;

import com.example.bai1.model.Blog;
import com.example.bai1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Category create(Category category);
    void delete(int id );
    Optional<Category> findById(int id);
}
