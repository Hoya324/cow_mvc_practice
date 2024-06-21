package com.cow.cow_mvc_practice.member.controller.dto.request;

import com.cow.cow_mvc_practice.member.entity.Member;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(title = "Member Request : 회원 등록 요청 DTO")
public class MemberRequest {

	@NotBlank(message = "회원 이름을 입력해주세요.")
	@Size(min = 2, max = 12, message = "사용자 이름은 2글자 이상 12글자 이하로 입력해주세요.")
	@Schema(description = "회원 이름")
	private String name;

	public Member toEntity() {
		return Member.from(this.name);
	}
}
