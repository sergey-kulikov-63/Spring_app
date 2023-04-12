package com.example.Spring.controllers;

import com.example.Spring.models.Comment;
import com.example.Spring.models.Post;
import com.example.Spring.repositories.CommentRepo;
import com.example.Spring.repositories.PostRepo;
import com.example.Spring.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/")
    public String main(Model model){
        Iterable<Post> posts = postRepo.findAll();
        model.addAttribute("posts", posts);
        return "main";
    }
    @GetMapping("/{id}")
    public String postView(@PathVariable Long id, Model model){
        Post post = postRepo.findById(id).orElse(null);
        List<Comment> comments = commentRepo.findByPost(post);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "post";
    }
}
