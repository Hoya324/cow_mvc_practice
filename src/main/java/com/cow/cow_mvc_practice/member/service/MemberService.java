package com.cow.cow_mvc_practice.member.service;

import java.util.List;

import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;

public interface MemberService {

	/* 기본 */
	// void join(MemberRequest memberRequest);
	// Member findOne(Long memberId);


	/* MemberResponse dto 적용 */
	MemberResponse findOne(Long memberId);
	MemberResponse join(String name);
	List<MemberResponse> findAll();
	MemberResponse updateMemberInfo(Long memberId, String name);
	void deleteMember(Long memberId);
}

