package com.ivaneskins.springboot.my_spring_boot.controller;


import com.ivaneskins.springboot.my_spring_boot.model.User;
import com.ivaneskins.springboot.my_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserControllerUpdate {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "getAllUsers";
    }

    @GetMapping("/add")
    public String newUser(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") int id,
                           Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "editPage";
    }

    @PutMapping("/edit")
    public String editUser(@ModelAttribute ("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
