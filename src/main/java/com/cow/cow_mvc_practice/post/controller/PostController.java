package com.cow.cow_mvc_practice.post.controller;

import com.cow.cow_mvc_practice.post.dto.request.CreatePostRequest;
import com.cow.cow_mvc_practice.post.dto.request.DeletePostRequest;
import com.cow.cow_mvc_practice.post.dto.response.CreatePostResponse;
import com.cow.cow_mvc_practice.post.dto.response.FindPostResponse;
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
    public CreatePostResponse create(@RequestBody final CreatePostRequest createPostRequest) {
        return postService.create(createPostRequest);
    }

    @GetMapping("{postId}")
    public FindPostResponse find(@PathVariable final Long postId) {
        return postService.find(postId);
    }

    @GetMapping("/all")
    public List<CreatePostResponse> findAll() {
        return postService.findAll();
    }

    @DeleteMapping("/{postId}")
    public void delete(@PathVariable final Long postId, @RequestBody final DeletePostRequest deletePostRequest) {
        postService.delete(postId, deletePostRequest);
    }
}