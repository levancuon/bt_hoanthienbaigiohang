package org.example.bt_hoanthienbaigiohang.controller;

import org.example.bt_hoanthienbaigiohang.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/cart")
public class CartController {
    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart();
    }
    @GetMapping("")
    public String cart(@SessionAttribute("cart") Cart cart, Model model) {
        model.addAttribute("cart" ,cart);
        return "/cart";
    }
}
