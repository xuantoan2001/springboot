package com.xuantoan.springboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("admin")
public class AdminController {
    @RequestMapping("/")
    public String index(Model model) {
        return "redirect:/admin/home";
    }
    @RequestMapping("/home")
    public String home(Model model) {
        return "admin/index";
    }
}
