package com.ecom.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String homeRedirect(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String homePage(@AuthenticationPrincipal UserDetails userDetails){
        log.info("Logged in As : {} with role as {}", userDetails.getUsername(), userDetails.getAuthorities());
        return "home";
    }
}
