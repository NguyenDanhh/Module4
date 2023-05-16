package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import javafx.scene.control.Separator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@Component
@RequestMapping("")
public class ProductController {
    private static final String SEPARATOR = "-";
    @Autowired
    private IProductService productService ;
    @GetMapping
    public String pageProduct(Model model){
        model.addAttribute("listProduct" , productService.getListProduct());
        return "products";
    }
    @GetMapping("/addtocart/{id}")
    public String addToCart(@PathVariable int id, @SessionAttribute(name = "cart") Cart cart , Model model) {
        boolean addProduct = false;
        Product product = productService.findById(id);
        for (Map.Entry<Integer , Integer> entry : cart.getSelectedProducts().entrySet()){
            if(entry.getKey() == product.getId()){
                entry.setValue(entry.getValue() + 1);
                addProduct = true ;
            }
            if(!addProduct){
                cart.getSelectedProducts().put(product.getId() , 1);
            }
        }
       return "redirect:/";
    }
    @GetMapping("/product-detail/{id}")
    public String getProductDetail(@PathVariable int id , Model model,
                                   @CookieValue(name = "seenProductId" , defaultValue = "")String ids,
                                   HttpServletResponse response){
        model.addAttribute("productDetail" , this.productService.findById(id));

        Cookie cookie;
        if("".equals(ids)){
            cookie = new Cookie("seenProductId" , Integer.toString(id));
        }else {
            String idString;
            String[] array = ids.split(SEPARATOR);
            if(array.length >= 3){
                idString = id
            }
        }
        return "detail";
    }
}
