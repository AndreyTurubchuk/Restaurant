package ru.topjava.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDefault {

    @GetMapping("/")
    public String login() {
        return "Добро пожаловать";
    }
/*

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }*/

}
