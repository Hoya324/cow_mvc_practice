package com.cow.cow_mvc_practice.post.controller;

import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;
import com.cow.cow_mvc_practice.post.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
  private final PostService postService;

  @PostMapping("/new/member/{memberId}")
  public PostResponse create(@PathVariable final Long memberId, @RequestBody final PostRequest postRequest) {
    return postService.join(memberId, postRequest);
  }

  @GetMapping("/{postId}")
  public PostResponse findPost(@PathVariable final Long postId) {
    return postService.findOne(postId);
  }

  @GetMapping()
  public PostResponse findPostQuery(@RequestParam("id") final Long postId) {
    return postService.findOne(postId);
  }

  @GetMapping("/all")
  public List<PostResponse> findPosts() {
    return postService.findAll();
  }

  @GetMapping("/all/member/{memberId}")
  public List<PostResponse> findPostsByMember(@PathVariable final Long memberId) {
    return postService.findAllByMember(memberId);
  }
}
