package com.cow.mvc.comment.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequest {
	private String title;
	private String content;
}
