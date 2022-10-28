package com.xuantoan.springboot.controller.web;

import com.xuantoan.springboot.entity.ProductEntity;
import com.xuantoan.springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class BaseController {
    @Autowired
    private IProductService productService;
    @RequestMapping("/")
    public String index(Model model) {
        return "redirect:/home";
    }
    @RequestMapping("/home")
    public String home(Model model) {
        List<ProductEntity> products = productService.findAll();
        model.addAttribute("products", products);
        return "web/index";
    }
}
