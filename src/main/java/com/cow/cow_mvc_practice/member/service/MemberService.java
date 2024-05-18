package com.cow.cow_mvc_practice.member.service;

import java.util.List;

import com.cow.cow_mvc_practice.member.dto.request.CreateMemberRequest;
import com.cow.cow_mvc_practice.member.dto.request.UpdateMemberRequest;
import com.cow.cow_mvc_practice.member.dto.response.CreateMemberResponse;
import com.cow.cow_mvc_practice.member.dto.response.FindMemberResponse;
import com.cow.cow_mvc_practice.member.dto.response.UpdateMemberResponse;

public interface MemberService {

	CreateMemberResponse createMember(CreateMemberRequest createMemberRequest);
	UpdateMemberResponse update(Long memberId, UpdateMemberRequest updateMemberRequest);
	FindMemberResponse findMember(Long memberId);
	List<FindMemberResponse> findAll();
}

