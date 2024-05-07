package com.cow.cow_mvc_practice.member.service;

import com.cow.cow_mvc_practice.member.controller.dto.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.MemberResponse;
import com.cow.cow_mvc_practice.member.entity.Member;

public interface MemberService {

	void join(MemberRequest memberRequest);
	// MemberResponse join(MemberRequest memberRequest);

	Member findOne(Long memberId);

	// MemberResponse findOne(Long memberId);

	// Member updateMember();
}

