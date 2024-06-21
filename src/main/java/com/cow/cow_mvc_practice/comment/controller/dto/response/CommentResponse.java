package com.cow.cow_mvc_practice.comment.controller.dto.response;

import java.time.LocalDateTime;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Schema(title = "Comment Response : 댓글 결과 DTO")
public class CommentResponse {
	@Schema(description = "댓글 ID")
	private final Long id;

	@Schema(description = "내용")
	private final String content;

	@Schema(description = "작성 날짜")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	private final LocalDateTime date;

	@Schema(description = "게시글 제목")
	private final String postTitle;

	@Schema(description = "댓글 작성자 ID")
	private final String memberName;

	@Builder
	private CommentResponse(final Long id, final String content, final LocalDateTime date,
		final String postTitle, final String memberName) {
		this.id = id;
		this.content = content;
		this.date = date;
		this.postTitle = postTitle;
		this.memberName = memberName;
	}

	public static CommentResponse from(final Comment comment) {
		return CommentResponse.builder()
			.id(comment.getId())
			.content(comment.getContent())
			.date(comment.getDate())
			.postTitle(comment.getPost().getTitle())
			.memberName(comment.getMember().getName())
			.build();
	}
}
