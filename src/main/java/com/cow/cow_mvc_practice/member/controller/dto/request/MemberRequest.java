package com.cow.cow_mvc_practice.member.controller.dto.request;

import com.cow.cow_mvc_practice.member.entity.Member;

import lombok.Getter;

@Getter
public class MemberRequest {
	 String name;

	 public Member toEntity() {
		return Member.builder()
				.name(name)
				.build();
	}
}
