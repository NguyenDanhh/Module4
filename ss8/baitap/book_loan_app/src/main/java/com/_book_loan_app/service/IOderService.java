package com._book_loan_app.service;

import com._book_loan_app.model.Book;
import com._book_loan_app.model.Oder;

import java.util.List;

public interface IOderService {
    List<Oder> findAll();
    Oder findById(int id);
    Oder createOder(Oder oder);

    int getCodeBook();
//    int getCodeOder(int code);

}
