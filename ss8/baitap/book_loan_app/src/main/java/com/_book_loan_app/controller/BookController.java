package com._book_loan_app.controller;

import com._book_loan_app.customexception.CheckCode;
import com._book_loan_app.model.Book;
import com._book_loan_app.model.Oder;
import com._book_loan_app.service.IBookService;
import com._book_loan_app.service.IOderService;
import com._book_loan_app.customexception.CheckBookZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOderService oderService;

    @GetMapping
    public String getBooks(Model model) {
        model.addAttribute("listBook", this.bookService.findAll());
        return "homepage";
    }

    @GetMapping("/books")
    public String getBooksAll(Model model) {
        model.addAttribute("listBook", this.bookService.findAll());
        return "book";
    }

    @GetMapping("/form-givebookback/{id}")
    public String showFormgiveBookBack(@PathVariable(value = "id") int id, Model model) {
        Book book = this.bookService.findById(id);
        model.addAttribute("book", book);
        return "/givebookback";
    }

    @GetMapping("/givebookback")
    public String giveBookBack(@RequestParam(value = "code") int code ,
                               @RequestParam(value = "id") int id ) throws CheckCode {
        Book book = bookService.findById(id);
        List<Oder> list = oderService.findAll();
        for (int i = 0; i < list.size(); i++) {
            if(code == list.get(i).getCode()){
                book.setCount(book.getCount() + 1);
                bookService.createBook(book);
                return "redirect:/";
            }
        }
        throw new CheckCode();
    }


    @GetMapping("/oder/{id}")
    public String oderBook(@PathVariable(name = "id") int id, Model model) throws CheckBookZero {
        Book book;
        Oder oder = new Oder();

        int codeBook = oderService.getCodeBook();
        model.addAttribute("codeBook", codeBook);
        Date borrowedTime = new Date();

        oder.setCode(codeBook);
        oder.setDate(borrowedTime);

        model.addAttribute("listOder", this.bookService.findAll());

        book = this.bookService.findById(id);
        if (book.getCount() == 0) {
       throw new CheckBookZero();
        }
        book.setCount(book.getCount() - 1);
        List<Oder> oders = book.getList();
        oders.add(oder);
        book.setList(oders);
        this.oderService.createOder(oder);
        this.bookService.createBook(book);


        return "homepage";
    }

    @ExceptionHandler(CheckBookZero.class)
    public ModelAndView checkBook() {
        ModelAndView modelAndView = new ModelAndView("errors");
        return modelAndView;
    }
    @ExceptionHandler(CheckCode.class)
    public String checkCode() {
        return "checkcode";
    }
}
