package com.cow.cow_mvc_practice.member.controller.dto.request;

import com.cow.cow_mvc_practice.member.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberRequest {
	Long id;
	final String name;

	@Builder
	private MemberRequest(final String name) {
		this.name = name;
	}

	public static Member toEntity(String name) {
		return Member.from(name);
	}
}
