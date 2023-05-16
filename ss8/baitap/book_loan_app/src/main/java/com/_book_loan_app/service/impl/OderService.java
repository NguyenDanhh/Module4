package com._book_loan_app.service.impl;

import com._book_loan_app.model.Oder;
import com._book_loan_app.repository.IOderRepository;
import com._book_loan_app.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderService implements IOderService {

    @Autowired
    private IOderRepository oderRepository;

    @Override
    public List<Oder> findAll() {
        return this.oderRepository.findAll();
    }

    @Override
    public Oder findById(int id) {
        return this.oderRepository.findById(id).get();
    }
//    @Override
//    public int getCodeOder(int code) {
//        return this.oderRepository.findByCode(code);
//    }
    @Override
    public Oder createOder(Oder oder) {
        return oderRepository.save(oder);
    }
    @Override
    public int getCodeBook(){
        int codeBook = (int) (Math.random() * (99999 - 10000) + 10000);
        List<Oder> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            if(codeBook == list.get(i).getCode()){
                codeBook = (int) (Math.random() * (99999 - 10000) + 10000);
                i = 0;
            }
        }
        return codeBook;
    }
}
