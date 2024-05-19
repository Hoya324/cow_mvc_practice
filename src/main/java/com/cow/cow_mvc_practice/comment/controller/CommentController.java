package com.cow.cow_mvc_practice.comment.controller;

import com.cow.cow_mvc_practice.comment.dto.request.CreateCommentRequest;
import com.cow.cow_mvc_practice.comment.dto.response.CreatedCommentResponse;
import com.cow.cow_mvc_practice.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post/{postId}/comment")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@PostMapping("/new")
	public CreatedCommentResponse create(@PathVariable Long postId, @RequestBody final CreateCommentRequest commentRequest) {
		return commentService.create(postId, commentRequest);
	}
}

