package com.cow.cow_mvc_practice.member.service;

import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import java.util.List;

import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import org.springframework.http.ResponseEntity;

public interface MemberService {
	MemberResponse findOne(Long memberId);
	MemberResponse join(MemberRequest memberRequest);
	List<MemberResponse> findAll();
	ResponseEntity<Void> delete(Long memberId);
  MemberResponse updateById(Long memberId, UpdateMemberRequest updateMemberRequest);
}