package com.cow.cow_mvc_practice.post.controller;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.request.UpdatePostRequest;
import com.cow.cow_mvc_practice.post.entity.Post;
import com.cow.cow_mvc_practice.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Post> registerPost(@RequestBody PostRequest request, Member member) {
        Post savedPost = postService.save(request, member.getId());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPost);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> findPost(@PathVariable long postId) {
        Post post = postService.findPost(postId);
        return ResponseEntity.ok()
                .body(post);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable long postId, @RequestBody UpdatePostRequest request) {
        Post updatedPost = postService.update(postId, request);
        return ResponseEntity.ok()
                .body(updatedPost);
    }
}
