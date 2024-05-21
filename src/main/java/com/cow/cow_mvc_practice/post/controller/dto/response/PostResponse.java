package com.cow.cow_mvc_practice.post.controller.dto.response;

import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    @Builder
    public PostResponse(Long id, String title, String content, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }
    public static PostResponse from(final Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .build();
       }
    }
