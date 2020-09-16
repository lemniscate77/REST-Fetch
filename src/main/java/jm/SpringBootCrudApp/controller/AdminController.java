package jm.SpringBootCrudApp.controller;


import jm.SpringBootCrudApp.model.User;
import jm.SpringBootCrudApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admin")
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userList", this.userService.allUsers());
        return "users-all";
    }

    @PostMapping(value = "/user/add")
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() == null) {
            userService.add(user);
        } else {
            userService.edit(user);
        }
        return "redirect:/admin";
    }

    @RequestMapping(value = "/remove/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        userService.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @RequestMapping(value = "/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, User user, Model model) {
        userService.edit(user);
        model.addAttribute("users", userService.allUsers());
        return "redirect:/admin";

    }
}
