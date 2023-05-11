package com.example.bai1.controller;

import com.example.bai1.model.Blog;
import com.example.bai1.model.Category;
import com.example.bai1.service.IBlogService;
import com.example.bai1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorys")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public String findAll(@PageableDefault(size = 1) Pageable pageable, Model model) {
        model.addAttribute("listCategory", categoryService.findAll(pageable));
        return "/category/list";
    }

    @GetMapping("form-create")
    private String showFormCreate(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @GetMapping("form-update/{id}")
    public String showFormUpdate(Model model , @PathVariable(value = "id") int id ){
        Category category = categoryService.findById(id);
        model.addAttribute("category" , category);
        return "category/update";
    }
    @GetMapping("delete-category")
    public String delete(@RequestParam(value = "id") int id ){
        categoryService.delete(id);
        return "redirect:/categorys";
    }
    @PostMapping("create-category")
    private String create(@ModelAttribute Category category){
        this.categoryService.create(category);
        return "redirect:/categorys";
    }
    @PostMapping("update-category")
    private String update(@ModelAttribute Category category){
        this.categoryService.update(category);
        return "redirect:/categorys";
    }

}
