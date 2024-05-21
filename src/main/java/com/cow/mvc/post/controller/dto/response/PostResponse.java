package com.cow.mvc.post.controller.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.cow.mvc.comment.entity.Comment;
import com.cow.mvc.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponse {
	private final Long id;
	private final String title;
	private final String content;
	private final String memberName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	private final LocalDateTime date;

	private final int commentCount;
	private final List<String> comments;

	@Builder
	private PostResponse(final Long id, final String title, final String content,
		final String memberName, final LocalDateTime date, final List<Comment> comments) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.memberName = memberName;
		this.date = date;
		this.comments = comments.stream().map(Comment::getContent).collect(Collectors.toList());
		this.commentCount = this.comments.size();
	}

	public static PostResponse from(final Post post) {
		return PostResponse.builder()
			.id(post.getId())
			.title(post.getTitle())
			.content(post.getContent())
			.memberName(post.getMember().getName())
			.date(post.getDate())
			.comments(post.getComments())
			.build();
	}
}
