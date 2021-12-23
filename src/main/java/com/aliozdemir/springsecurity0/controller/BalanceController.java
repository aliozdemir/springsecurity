package com.aliozdemir.springsecurity0.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/Balance")
    public String balance(){
        return "Balance";
    }
}
