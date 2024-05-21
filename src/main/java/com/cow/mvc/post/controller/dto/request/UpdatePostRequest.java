package com.cow.mvc.post.controller.dto.request;

import com.cow.mvc.member.entity.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdatePostRequest {
	private String title;
	private String content;
	private Member member;
}
