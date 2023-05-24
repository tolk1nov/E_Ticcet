package com.example.e_ticket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class StartController {
    @GetMapping
    public ModelAndView starting(){
        return new ModelAndView("index");
    }
}
