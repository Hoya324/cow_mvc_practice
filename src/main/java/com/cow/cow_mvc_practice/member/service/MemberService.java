package com.cow.cow_mvc_practice.member.service;

import com.cow.cow_mvc_practice.member.controller.dto.request.CreateMemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.CreateMemberResponse;
import java.util.List;

public interface MemberService {

	/* 기본 */
	// void join(CreateMemberRequest memberRequest);
	// Member findOne(Long memberId);


	/* CreateMemberResponse dto 적용 */
	CreateMemberResponse findOne(Long memberId);
	CreateMemberResponse join(CreateMemberRequest memberRequest);
	List<CreateMemberResponse> findAll();
	CreateMemberResponse update(Long memberId, UpdateMemberRequest updateMemberRequest);
}

