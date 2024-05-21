package com.cow.mvc.member.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cow.mvc.member.controller.dto.request.MemberRequest;
import com.cow.mvc.member.controller.dto.request.UpdateMemberRequest;
import com.cow.mvc.member.controller.dto.response.MemberResponse;

public interface MemberService {
	MemberResponse findOne(Long memberId);

	MemberResponse join(MemberRequest memberRequest);

	List<MemberResponse> findAll();

	ResponseEntity<Void> delete(Long memberId);

	MemberResponse updateById(Long memberId, UpdateMemberRequest updateMemberRequest);
}
