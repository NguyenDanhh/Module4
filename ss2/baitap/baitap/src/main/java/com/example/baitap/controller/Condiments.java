package com.example.baitap.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/save")
public class Condiments {


    @GetMapping("/condiment")
    public String condiments(@RequestParam(value = "condiment" ,required = false) String[] condiment , Model model){
        model.addAttribute("list" , condiment);
        return "condiments";
    }



}
