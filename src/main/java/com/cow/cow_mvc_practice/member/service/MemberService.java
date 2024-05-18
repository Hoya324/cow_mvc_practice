package com.cow.cow_mvc_practice.member.service;

import java.util.List;

import com.cow.cow_mvc_practice.member.dto.request.CreateMemberRequest;
import com.cow.cow_mvc_practice.member.dto.response.MemberResponse;

public interface MemberService {

	MemberResponse createMember(CreateMemberRequest createMemberRequest);
	MemberResponse update(Long memberId, String name);
	List<MemberResponse> findAll();
	MemberResponse findOne(Long memberId);
}

