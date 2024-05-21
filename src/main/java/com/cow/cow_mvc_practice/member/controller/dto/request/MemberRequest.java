package com.cow.cow_mvc_practice.member.controller.dto.request;

import com.cow.cow_mvc_practice.member.entity.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRequest {
	private String name;

	public Member toEntity() {
		return Member.from(this.name);
	}
}
