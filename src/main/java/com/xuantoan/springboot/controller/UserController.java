package com.xuantoan.springboot.controller;

import com.xuantoan.springboot.entity.UserEntity;
import com.xuantoan.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/user")
    public String index(Model model) {
        List<UserEntity> users = userService.findAll();

        model.addAttribute("users", users);

        return "admin/user/index";
    }

    @RequestMapping(value = "user/add")
    public String addUser(Model model) {
        model.addAttribute("user", new UserEntity());
        return "admin/user/addUser";
    }

    @RequestMapping(value = "user/edit", method = RequestMethod.GET)
    public String editUser(@RequestParam("id") Long userId, Model model) {
        UserEntity userEdit = userService.getUserById(userId);
        if(userEdit != null){
            model.addAttribute("user", userEdit);
        }

        return "admin/user/editUser";
    }

    @RequestMapping(value = "user/save", method = RequestMethod.POST)
    public String save(UserEntity user) {
        userService.saveOrUpdate(user);
        return "redirect:/user";
    }

    @RequestMapping(value = "user/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Long userId, Model model) {
        userService.deleteUser(userId);
        return "redirect:/user";
    }

}
