package com.cow.cow_mvc_practice.member.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(title = "Update Member Request : 회원 정보 수정 요청 DTO")
public class UpdateMemberRequest {
	@Schema(description = "수정하려는 회원 이름")
	private String name;
}
