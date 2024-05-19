package com.cow.cow_mvc_practice.comment.service;

import com.cow.cow_mvc_practice.comment.dto.request.CreateCommentRequest;
import com.cow.cow_mvc_practice.comment.dto.response.CreatedCommentResponse;

public interface CommentService {
	CreatedCommentResponse create(Long postId, CreateCommentRequest createCommentRequest);
}

