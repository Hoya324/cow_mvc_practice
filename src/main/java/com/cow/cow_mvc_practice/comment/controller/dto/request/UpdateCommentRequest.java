package com.cow.cow_mvc_practice.comment.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateCommentRequest {
    private String title;
    private String comment;
}
