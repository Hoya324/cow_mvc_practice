package com.cow.cow_mvc_practice.comment.controller.dto.response;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentResponse {

    private final String memberName;
    private final String comment;
    private final String postTitle;

    @Builder
    private CommentResponse(String memberName, final String comment, String postTitle) {
        this.memberName = memberName;
        this.comment = comment;
        this.postTitle = postTitle;
    }

    public static CommentResponse from(final Comment comment) {
        return CommentResponse.builder()
                .comment(comment.getComment())
                .build();
    }
}
