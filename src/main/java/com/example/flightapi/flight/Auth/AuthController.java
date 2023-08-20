package com.example.flightapi.flight.Auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/")
    public String Hello(){
        return "Welcome,home!";
    }

    @GetMapping("/secured")
    public String secured(){
        return "Login success";
    }
}
