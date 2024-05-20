package com.cow.cow_mvc_practice.post.dto.request;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Getter;

@Getter
public class CreatePostRequest {

    private Long id;
    private String title;
    private String content;

    public Post toEntity(Member member) {
        return Post.from(this.title, this.content, member);
    }
}
