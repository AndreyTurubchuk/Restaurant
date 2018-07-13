package ru.topjava.restaurant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDefault {

    @GetMapping("/")
    public String login() {
        return "Welcome";
    }
}
