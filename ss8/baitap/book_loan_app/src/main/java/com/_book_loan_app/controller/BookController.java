package com._book_loan_app.controller;

import com._book_loan_app.model.Book;
import com._book_loan_app.model.Oder;
import com._book_loan_app.service.IBookService;
import com._book_loan_app.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    IOderService oderService;

    @GetMapping
    public String getBooks(Model model) {
        model.addAttribute("listBook", this.bookService.findAll());

        return "homepage";
    }
    @GetMapping("/codeBook/{id}")
    public String codeBooks(@PathVariable(name = "id") int id,Model model){
        model.addAttribute("codebook" ,this.oderService.findById(id));
        return "/codebook";
    }

    @GetMapping("/books")
    public String getBooksAll(Model model) {
        model.addAttribute("listBook", this.bookService.findAll());
        return "book";
    }
    @GetMapping("/form-givebookback")
    public String showFormgiveBookBack(){
        return "/givebookback";
    }

    @GetMapping("/givebookback")
    public String giveBookBack(){

        return "redirect:/";
    }

    @GetMapping("/oder/{id}")
    public String oderBook(@PathVariable(name = "id") int id, Model model) throws Exception {
        Book book;
        Oder oder = new Oder();

        int codeBook = bookService.getCodeBook();
        Date borrowedTime = new Date();

        oder.setCode(codeBook);
        oder.setDate(borrowedTime);

        model.addAttribute("listOder", this.bookService.findAll());

        book = this.bookService.findById(id);
        if(book.getCount() == 0 ){
            throw  new Exception();
        }
        book.setCount(book.getCount() - 1);
        List<Oder> oders = book.getList();
        oders.add(oder);
        book.setList(oders);
        this.oderService.createOder(oder);
        this.bookService.createBook(book);


        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView error(){
        ModelAndView modelAndView = new ModelAndView("errors");
        return modelAndView;
    }
}
