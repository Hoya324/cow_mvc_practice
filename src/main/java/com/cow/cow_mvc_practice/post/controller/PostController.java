package com.cow.cow_mvc_practice.post.controller;

import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostCommentsResponse;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;
import com.cow.cow_mvc_practice.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/new/{memberName}")
    public PostResponse create(@PathVariable final String memberName, @RequestBody final PostRequest postRequest) {
        return postService.create(memberName, postRequest);
    }

    @GetMapping("/{postTitle}")
    public PostResponse findPost(@PathVariable String postTitle) {
        return postService.findOne(postTitle);
    }

    @GetMapping("/")
    public PostCommentsResponse getPostComments(@RequestParam String title) {
        return postService.getPostComments(title);
    }

    @GetMapping("/commentsAmount")
    public Integer getPostCommentsAmount(@RequestParam String title) {
        return postService.getCommentsAmount(title);
    }

}

