package com.cow.cow_mvc_practice.comment.controller.service;

import com.cow.cow_mvc_practice.comment.controller.dto.request.CommentDeleteRequest;
import com.cow.cow_mvc_practice.comment.controller.dto.request.CommentRequest;
import com.cow.cow_mvc_practice.comment.controller.dto.response.CommentResponse;
import com.cow.cow_mvc_practice.comment.entity.Comment;

import java.util.List;

public interface CommentService {
    CommentResponse create(CommentRequest commentRequest);

    boolean delete(String name, String title, CommentDeleteRequest request);
}
