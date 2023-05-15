package com.example.practice.controller;

import com.example.practice.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("counter")
public class CounterController {

    @ModelAttribute("counter")
    public Counter setCounter(){
        return new Counter();
    }
    @GetMapping
    public String get(@ModelAttribute("counter")Counter counter){
        counter.increment();
        return "interface";
    }
}
