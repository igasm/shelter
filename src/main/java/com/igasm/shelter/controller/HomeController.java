package com.igasm.shelter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Witaj w naszym schronisku");
        model.addAttribute("tagline", "Jedynym i wyjątkowym, oferujemy Burki i Perełki");

        return "welcome";
    }
}
