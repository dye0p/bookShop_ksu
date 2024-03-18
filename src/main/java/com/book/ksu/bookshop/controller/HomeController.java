package com.book.ksu.bookshop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homeP(Model model) {

        //사용자 이름
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        model.addAttribute("username", username); //사용자 이름

        return "home";
    }
}
