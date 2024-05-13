package com.cow.cow_mvc_practice.post.controller;

import com.cow.cow_mvc_practice.post.controller.dto.request.CreatePostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.CreatePostResponse;
import com.cow.cow_mvc_practice.post.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  // 게시글 생성
  @PostMapping("/new")
  public CreatePostResponse createPost(@RequestBody final CreatePostRequest createPostRequest) {
    return postService.createPost(createPostRequest);
  }

  // 특정 게시글 조회
  @GetMapping("/{postId}")
  public CreatePostResponse findPost(@PathVariable Long postId) {
    return postService.findOnePost(postId);
  }

  // 모든 게시글 조회
  @GetMapping("/all")
  public List<CreatePostResponse> findAllPost() {
    return postService.findAllPost();
  }

  // 게시글 삭제
  @DeleteMapping("/{postId}")
  public ResponseEntity<Long> deletePost(@PathVariable Long postId) {
    postService.delete(postId);
    return ResponseEntity.ok(postId);
  }
}
