package com.cow.cow_mvc_practice.comment.dto.response;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreatedCommentResponse {

    private final Long id;
    private final Long postId;
    private final Long memberId;
    private final String content;
    private final LocalDateTime createTime;

    @Builder
    private CreatedCommentResponse(final Long id, final Long postId, final Long memberId, final String content, final LocalDateTime createTime) {
        this.id = id;
        this.postId = postId;
        this.memberId = memberId;
        this.content = content;
        this.createTime = createTime;
    }

    public static CreatedCommentResponse from(final Comment comment) {
        return CreatedCommentResponse.builder()
                .id(comment.getId())
                .postId(comment.getPost().getId())
                .memberId(comment.getMember().getId())
                .content(comment.getContent())
                .createTime(comment.getCreatedAt()).build();
    }
}
