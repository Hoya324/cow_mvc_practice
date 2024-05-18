package com.cow.cow_mvc_practice.comment.service;

import com.cow.cow_mvc_practice.comment.dto.request.CommentRequest;
import com.cow.cow_mvc_practice.comment.dto.response.CommentResponse;

public interface CommentService {
	CommentResponse createComment(Long postId, CommentRequest commentRequest);
}

