package com.example.bai1.service.imp;

import com.example.bai1.model.Category;
import com.example.bai1.repository.ICategoryRepository;
import com.example.bai1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category create(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        this.categoryRepository.delete(findById(id).get());
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

}
