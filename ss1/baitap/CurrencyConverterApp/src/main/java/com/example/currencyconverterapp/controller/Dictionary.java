package com.example.currencyconverterapp.controller;


import com.example.currencyconverterapp.service.IDictionaryService;
import com.example.currencyconverterapp.service.imp.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dictionary {

    private static IDictionaryService iDictionaryService = new DictionaryService();
    @RequestMapping("/dictionary")
    public String getDictionary(@RequestParam(defaultValue = "0" )String dictionary , Model model){
        model.addAttribute("result" , iDictionaryService.findDictionary(dictionary));
        return "dictionary";
    }
}
