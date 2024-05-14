package com.cow.cow_mvc_practice.comment.controller.service;

import com.cow.cow_mvc_practice.comment.controller.dto.response.CommentResponse;
import com.cow.cow_mvc_practice.comment.controller.repository.CommentJPARepository;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;

import java.util.List;

public interface CommentService {
    CommentResponse join(Long memberId, Long postId, String comment);
    CommentResponse findOne(Long commentId);
    List<CommentResponse> findAll();
    void deleteComment(Long memberId);
}
