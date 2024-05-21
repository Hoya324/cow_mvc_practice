package com.cow.cow_mvc_practice.post.controller.dto.response;

import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Builder;

import java.util.List;

@Builder
public class PostResponse {
    private final String title;
    private final String content;

    @Builder
    public PostResponse(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static PostResponse from(Post post) {
        return PostResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
