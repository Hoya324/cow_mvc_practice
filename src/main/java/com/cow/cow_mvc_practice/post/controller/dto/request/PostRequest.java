package com.cow.cow_mvc_practice.post.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(title = "Post Request : 게시글 등록 요청 DTO")
public class PostRequest {
	@NotBlank(message = "게시글 제목을 입력해주세요.")
	@Schema(description = "게시글 제목")
	private String title;

	@NotBlank(message = "게시글 제목을 입력해주세요.")
	@Schema(description = "게시글 제목")
	private String content;
}
