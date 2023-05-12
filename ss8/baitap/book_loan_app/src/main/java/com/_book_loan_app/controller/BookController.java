package com._book_loan_app.controller;

import com._book_loan_app.model.Oder;
import com._book_loan_app.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {
    @Autowired
    IBookService bookService ;

    @GetMapping
    public String getBooks(Model model){
        model.addAttribute("listBook" , this.bookService.findAll());
        return "homepage";
    }

    @GetMapping("/oder/{id}")
    public String oderBook(@PathVariable(name = "id")int id , Model model){
        Oder oder = new Oder();
        int codeBook = (int)(Math.random()*(99999-10000) + 10000);
        model.addAttribute("listOder" , this.bookService.findAll());
        return "homepage";
    }
}
