package com.cow.cow_mvc_practice.member.service;

import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import java.util.List;

import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;

public interface MemberService {

	/* 기본 */
	// void join(MemberRequest memberRequest);
	// Member findOne(Long memberId);


	/* MemberResponse dto 적용 */
	MemberResponse findOne(Long memberId);
	MemberResponse join(MemberRequest memberRequest);
	List<MemberResponse> findAll();
	MemberResponse update(Long memberId, UpdateMemberRequest updateMemberRequest);
}

