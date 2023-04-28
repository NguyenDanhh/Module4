package com.example.currencyconverterapp.service.imp;

import com.example.currencyconverterapp.repository.IDictionaryRepository;
import com.example.currencyconverterapp.repository.imp.DictionaryRepository;
import com.example.currencyconverterapp.service.IDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    IDictionaryRepository iDictionaryRepository = new DictionaryRepository();
    @Override
    public String findDictionary(String dictionary) {
        return iDictionaryRepository.findDictionary(dictionary);
    }
}
