package com.example.currencyconverterapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dictionary {
    @RequestMapping("/dictionary")
    public String getDictionary(@RequestParam(defaultValue = "0" )String dictionary , Model model){
        String englishVocabulary[] = {"Cart" , "Bicycle" , "Motorcycle" , "Scooter" , "Car"};
        String vietNamVocabulary[] = {"xe ngựa" , "xe đạp" , "xe máy" , "xe tay ga" , "ô tô"};
        String dictionary1 = dictionary;
        String dictionary2 = "find not found";
        for (int i = 0; i < englishVocabulary.length; i++) {
            if(englishVocabulary[i].equals(dictionary1)){
                model.addAttribute("result" , vietNamVocabulary[i]);
                break;
            }else{
                model.addAttribute("result" , dictionary2);
            }
        }
        return "dictionary";
    }
}
