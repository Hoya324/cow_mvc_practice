package com.cow.cow_mvc_practice.member.service;

import java.util.List;

import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;

public interface MemberService {

	MemberResponse findOne(Long memberId);
	MemberResponse join(String name);
	MemberResponse update(Long memberId, String name);
	List<MemberResponse> findAll();
}

