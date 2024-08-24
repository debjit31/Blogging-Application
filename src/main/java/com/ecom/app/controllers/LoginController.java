package com.ecom.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String loginPage(Model model){
        return "login";
    }


}
