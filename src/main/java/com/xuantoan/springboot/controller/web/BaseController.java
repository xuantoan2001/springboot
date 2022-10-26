package com.xuantoan.springboot.controller.web;

import com.xuantoan.springboot.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BaseController {

    @RequestMapping("/")
    public String index(Model model) {
        return "redirect:/home";
    }
    @RequestMapping("/home")
    public String home(Model model) {
        return "web/index";
    }
}
