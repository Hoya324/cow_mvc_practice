package com.cow.cow_mvc_practice.member.service;

import com.cow.cow_mvc_practice.member.controller.dto.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.MemberResponse;
import com.cow.cow_mvc_practice.member.entity.Member;

public interface MemberService {

	/* 기본 */
	void join(MemberRequest memberRequest);
	Member findOne(Long memberId);

	/* MemberResponse dto 적용 */
	// MemberResponse findOne(Long memberId);
	// MemberResponse join(MemberRequest memberRequest);
}

