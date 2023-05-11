package com.example.bai1.service;

import com.example.bai1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    void create(Blog blog);
    void update(Blog blog);
    void delete(int id );
    Blog findById(int id);
}
