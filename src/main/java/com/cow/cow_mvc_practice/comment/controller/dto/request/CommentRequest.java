package com.cow.cow_mvc_practice.comment.controller.dto.request;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import lombok.Getter;

@Getter
public class CommentRequest {

    String comment;

    public Comment toEntity() {
        return Comment.builder()
                .comment(comment)
                .build();
    }
}
