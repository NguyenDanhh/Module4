package com.example.currencyconverterapp.repository.imp;

import com.example.currencyconverterapp.repository.ICurrencyRepository;
import org.springframework.stereotype.Repository;


@Repository
public class CurrencyRepository implements ICurrencyRepository {

    @Override
    public float convert(String usd) {
        float currency = Float.parseFloat(usd);
        float result = currency * 23000;
        return result;
    }
}
