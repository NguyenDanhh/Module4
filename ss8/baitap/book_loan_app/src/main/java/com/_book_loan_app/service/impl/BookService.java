package com._book_loan_app.service.impl;

import com._book_loan_app.model.Book;
import com._book_loan_app.repository.IBookRepository;
import com._book_loan_app.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return this.bookRepository.findById(id).get();
    }
}
