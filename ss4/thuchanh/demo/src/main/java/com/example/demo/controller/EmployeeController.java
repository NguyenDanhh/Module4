package com.example.demo.controller;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping(value = "showForm" , method = RequestMethod.GET)
    public String showForm(Model model){
        model.addAttribute("employee" , new Employee());
        return "create";
    }
}
