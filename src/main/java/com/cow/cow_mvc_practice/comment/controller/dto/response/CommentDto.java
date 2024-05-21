package com.cow.cow_mvc_practice.comment.controller.dto.response;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentDto {
    private final Long commentId;
    private final String title;
    private final String comment;

    @Builder
    private CommentDto(Long commentId, String title, String comment) {
        this.commentId = commentId;
        this.title = title;
        this.comment = comment;
    }

    public static CommentDto of(Comment comment) {
        return CommentDto.builder()
                .commentId(comment.getId())
                .title(comment.getTitle())
                .comment(comment.getComment())
                .build();
    }
}
