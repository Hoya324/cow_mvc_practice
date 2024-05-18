package com.cow.cow_mvc_practice.comment.dto.response;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponse {
	private final Long id;
	private final Long postId;
	private final Long memberId;
	private final String content;
	private final LocalDateTime createTime;


	@Builder
	private CommentResponse(final Long id, Long postId, Long memberId, final String content, LocalDateTime createTime) {
		this.id = id;
        this.postId = postId;
        this.memberId = memberId;
        this.content = content;
        this.createTime = createTime;
    }

	public static CommentResponse from(final Comment comment) {
		return CommentResponse.builder()
				.id(comment.getId())
				.postId(comment.getPost().getId())
				.memberId(comment.getMember().getId())
				.content(comment.getContent())
				.createTime(comment.getCreated_at()).build();
	}
}
