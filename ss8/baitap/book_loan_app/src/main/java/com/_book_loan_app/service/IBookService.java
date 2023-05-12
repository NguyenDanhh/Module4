package com._book_loan_app.service;

import com._book_loan_app.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(int id);
}
