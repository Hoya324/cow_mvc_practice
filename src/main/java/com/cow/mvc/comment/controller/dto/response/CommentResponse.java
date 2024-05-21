package com.cow.mvc.comment.controller.dto.response;

import java.time.LocalDateTime;

import com.cow.mvc.comment.entity.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentResponse {
	private final Long id;
	private final String content;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	private final LocalDateTime date;

	private final String postTitle;
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