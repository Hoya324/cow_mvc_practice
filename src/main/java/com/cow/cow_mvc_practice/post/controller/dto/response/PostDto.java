package com.cow.cow_mvc_practice.post.controller.dto.response;

import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDto {
    private final Long exhibitionId;
    private final String title;
    private final String content;

    @Builder
    private PostDto(Long exhibitionId, String title, String content, LocalDateTime createdAt) {
        this.exhibitionId = exhibitionId;
        this.title = title;
        this.content = content;
    }

    public static PostDto of(Post post) {
        return PostDto.builder()
                .exhibitionId(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
