package com.example.bai1.controller;

import com.example.bai1.model.Blog;
import com.example.bai1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("listBlogs", blogService.findAll());

        return "/blogs/list";
    }

    @GetMapping("form-create")
    private String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("listCategory", blogService.findAll());
        return "/blogs/create";
    }
}
