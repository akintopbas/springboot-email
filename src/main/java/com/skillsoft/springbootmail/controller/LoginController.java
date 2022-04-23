package com.skillsoft.springbootmail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping(value = "/")
    public String getWelcomePage(){
        return "welcome";
    }
    @GetMapping(value = "/home")
    public String getHomePage(){
        return "home";
    }
    @GetMapping(value = "/admin")
    public String getAdminPage(){
        return "admin";
    }

    @GetMapping(value = "/login")
    public String getLoginPage(){
        return "login";
    }

}
