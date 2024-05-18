package com.cow.cow_mvc_practice.post.controller.dto.response;

import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FindPostResponse {

    private final Long postId;
    private final String title;
    private final String content;
    private final LocalDateTime created_at;
    private final int commentCount;

    @Builder
    private FindPostResponse(final Long postId, final String title, final String content, LocalDateTime created_at, int commentCount) {
     this.postId = postId;
     this.title = title;
     this.content = content;
     this.created_at = created_at;
     this.commentCount = commentCount;
    }

    public static FindPostResponse from(Post post, int commentCount) {
        return FindPostResponse.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .created_at(post.getCreated_at())
                .commentCount(commentCount)
                .build();
    }
}
