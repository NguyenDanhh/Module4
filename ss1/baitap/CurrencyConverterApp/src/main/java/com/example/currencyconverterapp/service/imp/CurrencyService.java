package com.example.currencyconverterapp.service.imp;

import com.example.currencyconverterapp.repository.ICurrencyRepository;
import com.example.currencyconverterapp.repository.imp.CurrencyRepository;
import com.example.currencyconverterapp.service.ICurrencyService;
import org.springframework.stereotype.Service;


@Service
public class CurrencyService implements ICurrencyService {
    ICurrencyRepository iCurrencyRepository = new CurrencyRepository();
    @Override
    public float convert(String usd) {
        return iCurrencyRepository.convert(usd);
    }
}
