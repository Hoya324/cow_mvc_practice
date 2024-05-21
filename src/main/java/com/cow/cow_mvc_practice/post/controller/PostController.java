package com.cow.cow_mvc_practice.post.controller;

import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;
import com.cow.cow_mvc_practice.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/member/{memberId}")
    public PostResponse creatPost(@PathVariable final Long memberId, @RequestBody PostRequest postRequest){
        return postService.creatPost(memberId, postRequest);
    }

    @GetMapping("/{postId}")
    public PostResponse findPost(@PathVariable final Long postId){
        return postService.findOne(postId);
    }


}
