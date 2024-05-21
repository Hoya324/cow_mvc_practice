package com.cow.cow_mvc_practice.member.service;

import java.util.List;

import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberCommentsResponse;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;

public interface MemberService {

	/* 기본 */
	// void join(MemberRequest memberRequest);
	// Member findOne(Long memberId);

	/* MemberResponse dto 적용 */
	MemberResponse findOne(String memberName);

	MemberResponse create(MemberRequest memberRequest);

	List<MemberResponse> findAll();

	MemberResponse updateMemberInfo(UpdateMemberRequest updateMemberRequest);

	void deleteMember(String memberName);

	MemberCommentsResponse getMemberComments(String name);
}

