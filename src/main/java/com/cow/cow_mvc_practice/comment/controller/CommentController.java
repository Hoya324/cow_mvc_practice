package com.cow.cow_mvc_practice.comment.controller;

import com.cow.cow_mvc_practice.comment.dto.request.CommentRequest;
import com.cow.cow_mvc_practice.comment.dto.response.CommentResponse;
import com.cow.cow_mvc_practice.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post/{postId}/comment")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@PostMapping("/new")
	public CommentResponse createComment(@PathVariable Long postId, @RequestBody final CommentRequest commentRequest) {
		return commentService.createComment(postId, commentRequest);
	}
}

