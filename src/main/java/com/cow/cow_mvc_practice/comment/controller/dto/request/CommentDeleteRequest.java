package com.cow.cow_mvc_practice.comment.controller.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class CommentDeleteRequest {

    String content;

    @Builder
    public CommentDeleteRequest(String content) {
        this.content = content;
    }

}
