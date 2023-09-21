package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Post;
import edu.codeup.codeupspringblog.models.User;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import edu.codeup.codeupspringblog.repositories.UserRepository;
import edu.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailSvc;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailSvc) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailSvc = emailSvc;
    }


    @GetMapping("/posts/create")
    public String createPost(Model model ) {
        model.addAttribute("post", new Post());
        return "post-create";
    }
    @GetMapping("/posts")
    public String postIndexPage(Model model ) {
        model.addAttribute("posts", postDao.findAll());
        return "post-index";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {

        User hardCodeUser = userDao.findById(1L).get();
        Post newPost = new Post(
                post.getTitle(),
                post.getDescription(),
                hardCodeUser
        );
        postDao.save(newPost);
        emailSvc.prepareAndSend(newPost, "You created a new blogger", "Nice blogger man! not really, it sucks");
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model) {
        Post postToEdit = postDao.findById(id).get();
        model.addAttribute("post", postToEdit);
        return"edit";
    }

    @PostMapping("/{id}/edit")
    public String insertEdit(@ModelAttribute Post post, @PathVariable long id) {
        Post posToEdit = postDao.findById(id).get();
        posToEdit.setTitle(post.getTitle());
        posToEdit.setDescription(post.getDescription());
        postDao.save(posToEdit);
        return "redirect:/posts";
    }
}
