package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

//    @GetMapping("/posts")
//    @ResponseBody
//    public String postIndexPage(Model model ) {
//        model.addAttribute()
//    }

    @GetMapping("/{id}")
    @ResponseBody
    public String viewIndivdualPost(@PathVariable long id) {
        return "view an individual post";
    }


}
