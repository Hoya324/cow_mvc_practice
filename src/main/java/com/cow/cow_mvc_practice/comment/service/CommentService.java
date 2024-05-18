package com.cow.cow_mvc_practice.comment.service;

import com.cow.cow_mvc_practice.comment.controller.dto.request.CommentRequest;
import com.cow.cow_mvc_practice.comment.controller.dto.response.CommentResponse;
import java.util.List;

public interface CommentService {
  CommentResponse findOne(Long commentId);
  CommentResponse join(Long memberId, Long postId, CommentRequest commentRequest);
  List<CommentResponse> findAllByPost(Long postId);
  List<CommentResponse> findAllByMember(Long memberId);
  List<CommentResponse> findAll();
}