package com.cow.cow_mvc_practice.comment.controller.dto.response;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import lombok.Builder;

import java.util.List;

@Builder
public class CommentResponse {
    private final String title;
    private final String comment;

    @Builder
    public CommentResponse(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }

    public static CommentResponse from(Comment comment) {
        return CommentResponse.builder()
                .title(comment.getTitle())
                .comment(comment.getComment())
                .build();
    }
}
