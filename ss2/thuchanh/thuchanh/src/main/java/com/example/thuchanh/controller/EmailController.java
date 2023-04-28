package com.example.thuchanh.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private static Matcher matcher;
    @GetMapping("")
    public String getIndex(){
        return "/index";
    }

    private boolean validate(String regex){
        matcher = pattern.matcher(EMAIL_REGEX);
        return matcher.matches();
    }
    @PostMapping("validate")
    public String validateEmail(@RequestParam(value = "email" , required = false) String email, Model model){
        boolean flag = validate(email);
        if(!flag){
            model.addAttribute("message" , "Email không hợp lệ ");
            return "/index";
        }
        model.addAttribute("email" , email);
        return "result";
    }
}
