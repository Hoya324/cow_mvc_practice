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
    public CreatePostResponse createPost(@RequestBody final CreatePostRequest createPostRequest) {
        return postService.createPost(createPostRequest);
    }

    @GetMapping("{postId}")
    public FindPostResponse findPost(@PathVariable final Long postId){
        return postService.findPost(postId);
    }

    @DeleteMapping("/{postId}/delete")
    public String deletePost(@PathVariable final Long postId, @RequestBody final DeletePostRequest deletePostRequest){
        return postService.delete(postId, deletePostRequest);
    }

    @GetMapping("/all")
    public List<CreatePostResponse> findPosts() {
        return postService.findAll();
    }
}