package com.tdtu.midterm.controller;

import com.tdtu.midterm.global.GlobalData;
import com.tdtu.midterm.model.Product;
import com.tdtu.midterm.service.CategoryService;
import com.tdtu.midterm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping({"/", "/home"})
    public String home(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }
    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProduct());

        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }
    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id){
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProductsByCategoryId(id));

        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }
    @GetMapping("/shop/viewproduct/{id}")
    public String viewPro(Model model, @PathVariable long id){
        model.addAttribute("product", productService.getProductById(id).get());

        model.addAttribute("cartCount", GlobalData.cart.size());
        return "viewProduct";
    }

    @GetMapping("/shop/filter")
    public String getProductsByFilter(Model model,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double price) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getProductsByFilter(name, price));
        return "shop";
    }
}
