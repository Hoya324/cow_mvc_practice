package com.cow.cow_mvc_practice.member.controller.dto.response;

import com.cow.cow_mvc_practice.member.entity.Member;

import lombok.Builder;
import lombok.Getter;

@Getter // Class 내 모든 필드의 Getter method를 자동 생성한다.
public class MemberResponse {
	private final Long id;
	private final String name;

	@Builder // 어느 필드에 어떤 값을 채워야 할지 명확하게 정하여 생성 시점에 값을 채워준다.
	private MemberResponse(final Long id, final String name) {
		this.id = id;
		this.name = name;
	}

	public static MemberResponse from(final Member member) {
		return MemberResponse.builder()
			.id(member.getId()) // builder 선언을 하였기에 사용 가능
			.name(member.getName()) // builder 선언을 하였기에 사용 가능
			.build(); // builder 선언을 하였기에 사용 가능
	}
}
