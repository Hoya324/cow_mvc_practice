package com.cow.cow_mvc_practice.post.controller.dto.request;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Getter;

@Getter
public class DeletePostRequest {
    Long memberId;

    public Post toEntity(Member member) {
        return Post.builder()
                .build();
    }
}
