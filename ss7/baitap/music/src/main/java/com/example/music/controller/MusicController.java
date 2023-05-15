package com.example.music.controller;

import com.example.music.dto.MusicDTO;
import com.example.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/musics")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping
    public String showListMusic(Model model) {
        model.addAttribute("musicList", musicService.findAll());
        return "list";
    }

    @GetMapping("create")
    public String showFormCreateMusic(Model model) {
        model.addAttribute("music", new MusicDTO());
        return "formUpdateAndCreate";
    }

    @GetMapping("update/{id}")
    public String showFormUpdateMusic(@PathVariable int id , Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "formUpdateAndCreate";
    }

    @PostMapping("save-music")
    public String saveMusic(@Validated @ModelAttribute(value = "music") MusicDTO music, BindingResult bindingResult , Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("music" ,music );
            return "formUpdateAndCreate";
        }
        musicService.save(music);
        return "redirect:/musics";
    }
}