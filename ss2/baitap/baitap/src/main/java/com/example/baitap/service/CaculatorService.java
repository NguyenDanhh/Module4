package com.example.baitap.service;

import com.example.baitap.repository.CaculatorRepository;
import com.example.baitap.repository.ICaculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {
    @Autowired
    ICaculatorRepository iCondimentRepository ;
    @Override
    public int result(String type, int number1, int number2) {
        return iCondimentRepository.result(type,number1,number2);
    }
}
