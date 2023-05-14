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
        return this .bookRepository.findById(id).get();
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public int getCodeBook(){
        int codeBook = (int) (Math.random() * (99999 - 10000) + 10000);
        return codeBook;
    }
}
