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

import java.time.LocalDate;
import java.time.Period;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping
    public String getUsers(Model model , Pageable pageable){

        model.addAttribute("userDTO" , new CreateUserDTO());
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
                         BindingResult bindingResult,Model model){
        new CreateUserDTO().validate(userDTO,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("user" , userDTO);
            return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO , user);
        userService.create(user);
        return "redirect:/users";
    }

}
