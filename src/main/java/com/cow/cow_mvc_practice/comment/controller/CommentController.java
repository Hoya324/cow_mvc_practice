package com.cow.cow_mvc_practice.comment.controller;

import com.cow.cow_mvc_practice.comment.controller.dto.request.CommentRequest;
import com.cow.cow_mvc_practice.comment.controller.dto.response.CommentResponse;
import com.cow.cow_mvc_practice.comment.service.CommentService;
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
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
  private final CommentService commentService;

  @PostMapping("/new/member/{memberId}/post/{postId}")
  public CommentResponse create(@PathVariable final Long memberId, @PathVariable final Long postId, @RequestBody final CommentRequest commentRequest) {
    return commentService.join(memberId, postId, commentRequest);
  }

  @GetMapping("/{commentId}")
  public CommentResponse findMember(@PathVariable final Long commentId) {
    return commentService.findOne(commentId);
  }

  @GetMapping()
  public CommentResponse findCommentQuery(@RequestParam("id") final Long commentId) {
    return commentService.findOne(commentId);
  }

  @GetMapping("all")
  public List<CommentResponse> findComments() {
    return commentService.findAll();
  }

  @GetMapping("/all/member/{memberId}")
  public List<CommentResponse> findCommentsByMember(@PathVariable final Long memberId) {
    return commentService.findAllByMember(memberId);
  }

  @GetMapping("/all/post/{postId}")
  public List<CommentResponse> findCommentsByPost(@PathVariable final Long postId) {
    return commentService.findAllByPost(postId);
  }
}