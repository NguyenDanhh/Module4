package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/save")
public class Caculator {

    @GetMapping("/")
    public static void cacilator(@RequestParam(defaultValue = "0" , name = "number1")String number1 ,
                                 @RequestParam(defaultValue = "0" , name = "number2")String number2 ,
                                 Model model){

    }
}
