package com.example.cart.controller;

import com.example.cart.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CartController {
    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }
    @GetMapping("/cart")
    public String showCart(@SessionAttribute("cart")Cart cart, Model model){
        model.addAttribute("cart" , cart);
        return "cart";
    }
}
