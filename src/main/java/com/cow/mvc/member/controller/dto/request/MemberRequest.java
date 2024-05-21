package com.cow.mvc.member.controller.dto.request;

import com.cow.mvc.member.entity.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRequest {
	private String name;

	public Member toEntity() {
		return Member.builder()
			.name(this.name)
			.build();
	}
}
