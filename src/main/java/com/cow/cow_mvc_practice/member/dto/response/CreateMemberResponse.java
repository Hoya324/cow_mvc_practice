package com.cow.cow_mvc_practice.member.dto.response;

import com.cow.cow_mvc_practice.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateMemberResponse {
	private final Long id;
	private final String name;

	@Builder
	private CreateMemberResponse(final Long id, final String name) {
		this.id = id;
		this.name = name;
	}

	public static CreateMemberResponse from(final Member member) {
		return CreateMemberResponse.builder()
			.id(member.getId())
			.name(member.getName())
			.build();
	}
}
