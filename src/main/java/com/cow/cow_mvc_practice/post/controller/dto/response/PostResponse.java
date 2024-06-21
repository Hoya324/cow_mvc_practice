package com.cow.cow_mvc_practice.post.controller.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Schema(title = "Post Response : 게시글 결과 DTO")
public class PostResponse {

	@Schema(description = "게시글 ID")
	private final Long id;

	@Schema(description = "제목")
	private final String title;

	@Schema(description = "내용")
	private final String content;

	@Schema(description = "작성자 ID")
	private final String memberName;

	@Schema(description = "작성 날짜")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	private final LocalDateTime date;

	@Schema(description = "댓글 개수")
	private final int commentCount;

	@Schema(description = "작성된 댓글 내용")
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
