package com.cow.cow_mvc_practice.member.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "Update Member Request : 회원 정보 수정 요청 DTO")
public class UpdateMemberRequest {
	@NotBlank(message = "회원 이름을 입력해주세요.")
	@Schema(description = "수정하려는 회원 이름")
	private String name;
}
