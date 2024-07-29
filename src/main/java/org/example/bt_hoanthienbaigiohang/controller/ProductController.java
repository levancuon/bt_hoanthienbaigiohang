package org.example.bt_hoanthienbaigiohang.controller;

import org.example.bt_hoanthienbaigiohang.model.Cart;
import org.example.bt_hoanthienbaigiohang.model.Product;
import org.example.bt_hoanthienbaigiohang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart();
    }

    @GetMapping("")
    private String listProduct(Model model) {
        Iterable<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/shop";
    }

    @GetMapping("/{id}/addToCart")
    private String action(@PathVariable("id") Long id,
                          @ModelAttribute Cart cart,
                          @RequestParam("action") String action) {
        Product product = productService.findById(id);
        if (action == null) {
            return "/error404";
        } else if(action.equals("add")){
            cart.addProduct(product);
            return "redirect:/cart";
        } else if(action.equals("minus")){
            cart.minusProduct(product);
            return "redirect:/cart";
        } else {
            cart.addProduct(product);
            return "redirect:/product";
        }

    }

}
