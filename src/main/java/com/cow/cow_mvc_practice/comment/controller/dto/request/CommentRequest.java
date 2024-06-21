package com.cow.cow_mvc_practice.comment.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(title = "Comment Request : 댓글 등록 요청 DTO")
public class CommentRequest {
	@NotBlank(message = "댓글 내용을 입력해주세요.")
	@Schema(description = "댓글 내용")
	private String content;
}
