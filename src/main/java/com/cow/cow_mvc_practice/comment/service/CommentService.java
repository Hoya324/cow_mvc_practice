package com.cow.cow_mvc_practice.comment.service;

import com.cow.cow_mvc_practice.comment.dto.request.CreateCommentRequest;
import com.cow.cow_mvc_practice.comment.dto.response.CreateCommentResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
public interface CommentService {

  CreateCommentResponse createComment(CreateCommentRequest createCommentRequest);

}
