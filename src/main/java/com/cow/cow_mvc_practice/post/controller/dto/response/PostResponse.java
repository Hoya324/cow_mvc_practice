package com.cow.cow_mvc_practice.post.controller.dto.response;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final Member member;
    @Builder
    private PostResponse(final Long id, final String title, final String content, final Member member) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public static PostResponse from(final Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .member(post.getMember())
                .build();
    }
}
