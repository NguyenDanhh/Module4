package com.example.bai1.controller;

import com.example.bai1.model.Category;
import com.example.bai1.service.IBlogService;
import com.example.bai1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorys")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> findAll() {
        List<Category> list = categoryService.findAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Category> delete(@PathVariable int id ){
        this.blogService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("create")
    private ResponseEntity<Category> create(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    private ResponseEntity<Category> update(@PathVariable int id , @RequestBody Category category){
        Optional<Category> categoryUpdate = categoryService.findById(id);
        if (!categoryUpdate.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setId(categoryUpdate.get().getId());
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.OK);
    }

}
