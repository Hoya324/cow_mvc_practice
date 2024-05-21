package com.cow.cow_mvc_practice.post.controller;

import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
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

    @PostMapping("/new")
    public PostResponse create(@RequestBody final PostRequest postRequest) {
        return postService.make(postRequest);
    }
    @GetMapping("/{postId}")
    public PostResponse findMember(@PathVariable final Long postId) {
        return postService.findOne(postId);
    }
    @GetMapping("/all")
    public List<PostResponse> findAllPost() {
        return postService.findAll();
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable final Long postId) {
        postService.deletePost(postId);
    }

}
