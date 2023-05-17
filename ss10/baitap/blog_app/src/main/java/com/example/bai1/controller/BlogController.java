package com.example.bai1.controller;

import com.example.bai1.model.Blog;
import com.example.bai1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<Iterable<Blog>> findAll() {
        List<Blog> list = blogService.findAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Blog> delete(@PathVariable int id ){
        this.blogService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("create")
    private ResponseEntity<Blog> create(@RequestBody Blog blog){
        return new ResponseEntity<>(blogService.create(blog), HttpStatus.CREATED);
    }
    @PatchMapping("update/{id}")
    private ResponseEntity<Blog> update(@PathVariable int id , @RequestBody Blog blog){
        Optional<Blog> blogUpdate = blogService.findById(id);
        if (!blogUpdate.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogUpdate.get().getId());
        return new ResponseEntity<>(blogService.create(blog), HttpStatus.OK);
    }
    @GetMapping("search/{nameCategory}")
    public ResponseEntity<List<Blog>> searchByTypeBlog(@PathVariable(name = "nameCategory")String nameCategory){
        List<Blog> blog = blogService.findByName(nameCategory);
        if (!blog.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
    @GetMapping("blogdetail/{id}")
    public ResponseEntity<Blog> findCustomerById(@PathVariable int id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }
}
