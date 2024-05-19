package com.cow.cow_mvc_practice.member.dto.request;

import com.cow.cow_mvc_practice.member.entity.Member;
import lombok.Getter;

@Getter
public class UpdateMemberRequest {

	private String name;

	public void updateEntity(Member member) {
		member.updateName(name);
	}
}
