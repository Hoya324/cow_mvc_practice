package com.cow.cow_mvc_practice.member.dto.response;

import com.cow.cow_mvc_practice.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdatedMemberResponse {

	private final Long id;
	private final String name;

	@Builder
	private UpdatedMemberResponse(final Long id, final String name) {
		this.id = id;
		this.name = name;
	}

	public static UpdatedMemberResponse from(final Member member) {
		return UpdatedMemberResponse.builder()
			.id(member.getId())
			.name(member.getName())
			.build();
	}
}
