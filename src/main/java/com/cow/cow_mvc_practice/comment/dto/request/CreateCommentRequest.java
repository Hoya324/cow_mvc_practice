package com.cow.cow_mvc_practice.comment.dto.request;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import lombok.Getter;

@Getter
public class CreateCommentRequest {

    private Long id;
    private String content;

    public Comment toEntity() {
        return Comment.builder()
                .content(this.content)
                .build();
    }
}
