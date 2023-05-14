package com._book_loan_app.service.impl;

import com._book_loan_app.model.Book;
import com._book_loan_app.model.Oder;
import com._book_loan_app.repository.IOderRepository;
import com._book_loan_app.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderService implements IOderService {

    @Autowired
    IOderRepository oderRepository;

    @Override
    public List<Oder> findAll() {
        return this.oderRepository.findAll();
    }

    @Override
    public Oder findById(int id) {
        return this.oderRepository.findById(id).get();
    }
    @Override
    public Oder createOder(Oder oder) {
        return oderRepository.save(oder);
    }
}
