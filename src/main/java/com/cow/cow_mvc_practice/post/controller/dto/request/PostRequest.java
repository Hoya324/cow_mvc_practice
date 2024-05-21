package com.cow.cow_mvc_practice.post.controller.dto.request;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Getter;

import java.util.List;

@Getter
public class PostRequest {

    private Member member;
    private String title;
    private String content;

    public Post toEntity(Member member) {
        return Post.builder()
                .member(member)
                .title(title)
                .content(content)
                .build();
    }
}
