package com.cow.cow_mvc_practice.post.controller.dto.request;

import com.cow.cow_mvc_practice.member.entity.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdatePostRequest {
	private String title;
	private String content;
	private Member member;
}
