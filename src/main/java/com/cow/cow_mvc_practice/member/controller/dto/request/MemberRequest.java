package com.cow.cow_mvc_practice.member.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class MemberRequest {
	Long id;
	final String name;
}
