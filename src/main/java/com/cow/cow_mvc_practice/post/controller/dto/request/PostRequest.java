package com.cow.cow_mvc_practice.post.controller.dto.request;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Builder
public class PostRequest {

    String title;
    String content;

    public Post toEntity(Member member) {
        return Post.builder()
                .member(member)
                .title(title)
                .content(content)
                .build();
    }
}
