package com.example.productmanagement.controller;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;


    @GetMapping()
    public String listStudents(Model model){
        model.addAttribute("listProduct" , iProductService.findAll() );
        return "list";
    }


    @GetMapping("form-create")
    public String showFormCreate(Model model){
        model.addAttribute("product" , new Product());
        return "create";
    }


    @GetMapping("/{id}/form-update")
    public String showFormUpdate(@PathVariable int id , Model model){
        Product product = iProductService.findById(id);
        model.addAttribute("product" , product);
        return "update";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id") int id ){
        iProductService.delete(id);
        return "redirect:/product";
    }

    @PostMapping("create-product")
    public String create(@ModelAttribute Product product){
        this.iProductService.create(product);
        return "redirect:/product";
    }


    @PostMapping("update-product")
    public String update(@ModelAttribute Product product){
        iProductService.update(product);
        return "redirect:/product";
    }
}
