package com.aliozdemir.springsecurity0.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/Loans")
    public String loans(){
        return "Loans";
    }
}
