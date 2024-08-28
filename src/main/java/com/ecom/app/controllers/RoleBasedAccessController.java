package com.ecom.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleBasedAccessController {

    @GetMapping("/manager")
    public String manager(){
        return "This is the manager page !!! ";
    }

    @GetMapping("/employee")
    public String employee(){
        return "This is the employee page !!! ";
    }


}
