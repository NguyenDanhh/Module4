package com.example.bai1.service.imp;

import com.example.bai1.model.Blog;
import com.example.bai1.repository.IBlogRepository;
import com.example.bai1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public Blog create(Blog blog) {
        return this.blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        this.blogRepository.delete(findById(id).get());
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public List<Blog> findByName(String nameCategory) {
        return this.blogRepository.findByName(nameCategory);
    }

}
