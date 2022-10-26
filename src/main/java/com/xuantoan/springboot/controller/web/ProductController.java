package com.xuantoan.springboot.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    @RequestMapping("/product/detail")
    public String index(Model model) {
        return "web/product/detail";
    }
}
