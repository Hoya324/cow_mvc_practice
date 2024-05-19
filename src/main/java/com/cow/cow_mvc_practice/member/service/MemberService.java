package com.cow.cow_mvc_practice.member.service;

import java.util.List;

import com.cow.cow_mvc_practice.member.dto.request.CreateMemberRequest;
import com.cow.cow_mvc_practice.member.dto.request.UpdateMemberRequest;
import com.cow.cow_mvc_practice.member.dto.response.CreatedMemberResponse;
import com.cow.cow_mvc_practice.member.dto.response.FoundMemberResponse;
import com.cow.cow_mvc_practice.member.dto.response.UpdatedMemberResponse;

public interface MemberService {

	CreatedMemberResponse create(CreateMemberRequest createMemberRequest);

	FoundMemberResponse find(Long memberId);

	List<FoundMemberResponse> findAll();

	UpdatedMemberResponse update(Long memberId, UpdateMemberRequest updateMemberRequest);
}

