package com.cow.cow_mvc_practice.comment.controller;

import com.cow.cow_mvc_practice.comment.dto.request.CreateCommentRequest;
import com.cow.cow_mvc_practice.comment.dto.response.CreateCommentResponse;
import com.cow.cow_mvc_practice.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
  private final CommentService commentService;

  @PostMapping("/new")
  public CreateCommentResponse create(@RequestBody final CreateCommentRequest createCommentRequest) {
    return commentService.createComment(createCommentRequest);
  }
}
