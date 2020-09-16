package jm.SpringBootCrudApp.controller;


import jm.SpringBootCrudApp.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String getHomePage() {

        return "index";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }


    @GetMapping(value = "/user")
    public String getUserPage(Model model) {
        UserDetails user = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("user", userService.getUserByName(user.getUsername()));
        return "user-details";
    }


}