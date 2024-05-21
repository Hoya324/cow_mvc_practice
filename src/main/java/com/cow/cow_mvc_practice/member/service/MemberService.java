package com.cow.cow_mvc_practice.member.service;

import java.util.List;

import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import org.springframework.transaction.annotation.Transactional;

public interface MemberService {

	/* 기본 */
	// void join(MemberRequest memberRequest);
	// Member findOne(Long memberId);


	/* MemberResponse dto 적용 */
	MemberResponse findOne(Long memberId);
	MemberResponse join(String name);
	List<MemberResponse> findAll();


	@Transactional
	MemberResponse updateMemberName(Long memberId, MemberRequest memberRequest);
}

