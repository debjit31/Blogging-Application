package com.ecom.app.controllers;

import com.ecom.app.model.User;
import com.ecom.app.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping("/login")
    public String loginPage(Model model){
        return "login";
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new RedirectView("/login?logout=true");
    }

    @GetMapping("/registerPage")
    public String displayRegister(Model model){
        model.addAttribute("user", new User());
        return "registerPage";
    }

    @PostMapping("/registerUser")
    public String addUser(@ModelAttribute("user") User registrationRequest){
        log.info("Received user registration object : {}", registrationRequest);

        com.ecom.app.entity.User userDbObject = com.ecom.app.entity.User
                .builder()
                .userName(registrationRequest.getUsername())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .role(registrationRequest.getRoles().get(0))
                .build();

        userRepository.save(userDbObject);

        return "login";
    }


}
