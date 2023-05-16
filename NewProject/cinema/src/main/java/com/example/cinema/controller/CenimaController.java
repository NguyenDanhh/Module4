package com.example.cinema.controller;

import com.example.cinema.Service.ICenimaService;
import com.example.cinema.dto.CreateMovieDto;
import com.example.cinema.model.CinemaInterest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Component
@RequestMapping("")
public class CenimaController {

    @Autowired
    private ICenimaService cenimaService;
    @GetMapping
    public String getCenimaInterset(Model model){
        List<CinemaInterest> list = cenimaService.getAllCinemaInterest();
        model.addAttribute("list" , list);
        return "list";
    }

    @GetMapping("form-create")
    public String showFormCreate(Model model){
        model.addAttribute("movie" , new CreateMovieDto());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute CreateMovieDto movie ,
                         BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("movie" , movie);
            return "create";
        }
        CinemaInterest cinemaInterest = new CinemaInterest();
        BeanUtils.copyProperties(movie , cinemaInterest);
        this.cenimaService.create(cinemaInterest);
        return "redirect:/";
    }
}
