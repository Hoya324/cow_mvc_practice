package com.cow.cow_mvc_practice.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cow.cow_mvc_practice.member.controller.dto.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.MemberResponse;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/new")
	public String create(@RequestBody final MemberRequest memberRequest) {
		memberService.join(memberRequest);
		return "회원저장 성공!";
	}

	/* response dto */
	// @PostMapping("/new")
	// public MemberResponse create(@RequestBody final MemberRequest memberRequest) {
	// 	return memberService.join(memberRequest);
	// }

	@GetMapping("/{memberId}")
	public String findMember(@PathVariable final Long memberId) {
		Member member = memberService.findOne(memberId);
		return "member 아이디: " + member.getId() + ", member 이름: " + member.getName();
	}

	// @GetMapping("/{memberId}")
	// public MemberResponse findMember(@PathVariable final Long memberId) {
	// 	Member member = memberService.findOne(memberId);
	// }
}

