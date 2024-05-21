package com.cow.cow_mvc_practice.post.dto.response;

import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DeletePostResponse {

    private final Long postId;
    private final String title;
    private final String content;
    private final LocalDateTime created_at;

    @Builder
    private DeletePostResponse(final Long postId, final String title, final String content, LocalDateTime created_at) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
    }

    public static DeletePostResponse from(Post post) {
        return DeletePostResponse.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .created_at(post.getCreatedAt())
                .build();
    }
}
