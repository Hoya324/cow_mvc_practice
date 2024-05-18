package com.cow.cow_mvc_practice.member.dto.response;

import com.cow.cow_mvc_practice.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FindMemberResponse {
	private final Long id;
	private final String name;

	@Builder
	private FindMemberResponse(final Long id, final String name) {
		this.id = id;
		this.name = name;
	}

	public static FindMemberResponse from(final Member member) {
		return FindMemberResponse.builder()
			.id(member.getId())
			.name(member.getName())
			.build();
	}
}
