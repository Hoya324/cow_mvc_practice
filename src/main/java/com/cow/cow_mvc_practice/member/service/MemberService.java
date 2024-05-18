package com.cow.cow_mvc_practice.member.service;

import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import java.util.List;

import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;

public interface MemberService {
	MemberResponse findOne(Long memberId);
	MemberResponse join(MemberRequest memberRequest);
	List<MemberResponse> findAll();
	String delete(Long memberId);
  MemberResponse updateById(Long memberId, UpdateMemberRequest updateMemberRequest);
}