package com.cow.cow_mvc_practice.comment.controller.dto.request;

import lombok.Getter;

@Getter
public class CommentDeleteRequest {

    String name;
    String title;
    String comment;

    public CommentDeleteRequest(String name, String title, String comment) {
        this.name = name;
        this.title = title;
        this.comment = comment;
    }
}
