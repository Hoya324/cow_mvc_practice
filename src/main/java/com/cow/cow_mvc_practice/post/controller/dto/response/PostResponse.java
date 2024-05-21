package com.cow.cow_mvc_practice.post.controller.dto.response;

import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Getter;

@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private String memberName;


    private PostResponse(Long id, String title, String content, String memberName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberName = memberName;

    }

    public static PostResponse from(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getMember().getName()
        );
    }
}