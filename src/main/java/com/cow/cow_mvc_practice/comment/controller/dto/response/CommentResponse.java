package com.cow.cow_mvc_practice.comment.controller.dto.response;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentResponse {

    private final String comment;

    @Builder
    private CommentResponse(final String comment) {
        this.comment = comment;
    }

    public static CommentResponse from(final Comment comment) {
        return CommentResponse.builder()
                .comment(comment.getComment())
                .build();
    }
}
