package com.example.validateexercise.controller;

import com.example.validateexercise.dto.CreateUserDTO;
import com.example.validateexercise.model.User;
import com.example.validateexercise.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping
    public String getUsers(Model model , Pageable pageable){
        model.addAttribute("listUser" , userService.findAll(pageable));
        return "list";
    }

    @GetMapping("form-update")
    public String showFormCreate(Model model){
        model.addAttribute("user" , new CreateUserDTO());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute(name = "user") CreateUserDTO userDTO ,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
           return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO , user);
        this.userService.create(user);
        return "redirect:/users";
    }

}
