package com.example.configurable_program.controller;

import com.example.configurable_program.model.Email;
import com.example.configurable_program.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private IEmailService iEmailService;
    @GetMapping("")
    public String display(Model model){
        model.addAttribute("email" , iEmailService.getEmail());
        return "list";
    }
    @GetMapping("update-form")
    public String getFormUpdate(Model model){
        model.addAttribute("email",iEmailService.getEmail());
        model.addAttribute("language" , iEmailService.getLanguages());
        model.addAttribute("pageSize" , iEmailService.getPageSize());
        return "update";
    }

    @PostMapping
    public String updateEmail(@ModelAttribute Email email){
        iEmailService.update(email);
        return "redirect:/email";
    }

}
