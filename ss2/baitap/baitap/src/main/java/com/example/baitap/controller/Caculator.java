package com.example.baitap.controller;



import com.example.baitap.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class Caculator {
    @Autowired
    ICaculatorService iCaculatorService ;

    @GetMapping("/caculator")
    public String caculator(@RequestParam(defaultValue = "0", name = "number1") int number1,
                         @RequestParam(defaultValue = "0", name = "number2") int number2,
                         @RequestParam(required = false, value = "caculator" ,defaultValue = "0") String type , Model model) {
        model.addAttribute("result" ,iCaculatorService.result(type,number1,number2));
        return "result";
    }
}
