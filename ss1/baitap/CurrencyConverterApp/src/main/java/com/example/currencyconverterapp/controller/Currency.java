package com.example.currencyconverterapp.controller;

import com.example.currencyconverterapp.service.ICurrencyService;
import com.example.currencyconverterapp.service.imp.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Currency {

    ICurrencyService iCurrencyService = new CurrencyService();
    @RequestMapping("/currency")
    public String getCurrency(@RequestParam(defaultValue = "0" , name = "usd") String usd, Model model) {
        model.addAttribute("result" , iCurrencyService.convert(usd));
        return "result";
    }

}
