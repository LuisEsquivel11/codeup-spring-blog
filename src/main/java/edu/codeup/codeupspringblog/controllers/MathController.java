package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MathController {

    @GetMapping("/add")
    public String add(int num)
}
