package com.cow.cow_mvc_practice.member.controller;

import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;


	@PostMapping("/new")
	public MemberResponse create(@RequestBody final MemberRequest memberRequest) {
		return memberService.join(memberRequest);
	}

	@GetMapping("/{memberId}")
	public MemberResponse findMember(@PathVariable final Long memberId) {
		return memberService.findOne(memberId);
	}

	@GetMapping()
	public MemberResponse findMemberQuery(@RequestParam final Long memberId) {
		return memberService.findOne(memberId);
	}

	@GetMapping("all")
	public List<MemberResponse> findMembers() {
		return memberService.findAll();
	}

	@PostMapping("{memberId}")
	public MemberResponse editMember(@PathVariable final Long memberId, final UpdateMemberRequest updateMemberRequest) {
		return memberService.update(memberId, updateMemberRequest);
	}
}

