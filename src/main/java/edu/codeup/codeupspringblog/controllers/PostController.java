package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Post;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import edu.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }



    @GetMapping("/posts/create")
    public String createPost(Model model ) {

        return "post-create";
    }
    @GetMapping("/posts")
    public String postIndexPage(Model model ) {
        model.addAttribute("posts", postDao.findAll());
        return "post-index";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description, Model model) {
        Post newPost = new Post(title, description);
        postDao.save(newPost);
        return "redirect:/posts";
    }


}
