package com.example.bai1.controller;

import com.example.bai1.model.Blog;
import com.example.bai1.service.IBlogService;
import com.example.bai1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("listBlogs", blogService.findAll());
        return "/blogs/list";
    }

    @GetMapping("form-create")
    private String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("listCategory", categoryService.findAll());
        return "/blogs/create";
    }

    @GetMapping("form-update/{id}")
    public String showFormUpdate(Model model , @PathVariable(value = "id") int id ){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog" , blog);
        model.addAttribute("listCategory" , categoryService.findAll());

        return "blogs/update";
    }
    @GetMapping("delete-blog")
    public String delete(@RequestParam(value = "id") int id ){
        blogService.delete(id);
        return "redirect:/blogs";
    }
    @PostMapping("create-blog")
    private String create(@ModelAttribute Blog blog){
        this.blogService.create(blog);
        return "redirect:/blogs";
    }
    @PostMapping("update-blog")
    private String update(@ModelAttribute Blog blog){
        this.blogService.update(blog);
        return "redirect:/blogs";
    }


}
