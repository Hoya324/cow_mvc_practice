package com.cow.cow_mvc_practice.member.controller.dto.request;

import com.cow.cow_mvc_practice.member.entity.Member;
import lombok.Getter;

@Getter // Class 내 모든 필드의 Getter method를 자동 생성한다.
public class UpdateMemberRequest {

	Long id;
	String name;

}
