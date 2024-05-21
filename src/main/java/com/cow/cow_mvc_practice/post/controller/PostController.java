package com.cow.cow_mvc_practice.post.controller;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.service.MemberService;
import com.cow.cow_mvc_practice.post.service.PostService;
import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final MemberService memberService;
    private final PostService postService;

    @PostMapping("/{postId}")
    public PostResponse create(@PathVariable Long postId, @RequestBody final PostRequest postRequest){
        Member member = postService.postFindOne(postId);
        return postService.join(postId,postRequest.getTitle(),postRequest.getContent(),member);
    }
}
