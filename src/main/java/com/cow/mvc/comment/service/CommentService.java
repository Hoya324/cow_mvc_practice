package com.cow.mvc.comment.service;

import java.util.List;

import com.cow.mvc.comment.controller.dto.request.CommentRequest;
import com.cow.mvc.comment.controller.dto.response.CommentResponse;

public interface CommentService {
	CommentResponse findOne(Long commentId);

	CommentResponse join(Long memberId, Long postId, CommentRequest commentRequest);

	List<CommentResponse> findAllByPost(Long postId);

	List<CommentResponse> findAllByMember(Long memberId);

	List<CommentResponse> findAll();
}
