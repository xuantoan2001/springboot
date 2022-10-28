package com.xuantoan.springboot.controller.web;

import com.xuantoan.springboot.entity.ProductEntity;
import com.xuantoan.springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductDetailController {
    @Autowired
    private IProductService productService;
    @RequestMapping("/product/detail")
    public String index(Model model) {
        return "web/product/detail";
    }



}
