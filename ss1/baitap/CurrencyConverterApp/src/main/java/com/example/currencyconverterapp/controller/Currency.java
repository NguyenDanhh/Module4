package com.example.currencyconverterapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

@Controller
public class Currency {
    @RequestMapping("/currency")
    public String getCurrency(@RequestParam(defaultValue = "0" , name = "usd") String usd, Model model) {
        float currency = Float.parseFloat(usd);
        float result = currency * 23000;
        model.addAttribute("result" , result);
        return "result";
    }

}
