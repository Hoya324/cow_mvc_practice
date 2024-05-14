package com.cow.cow_mvc_practice.member.controller;

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
import com.cow.cow_mvc_practice.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	/* 기본 */
	// @PostMapping("/new")
	// public String create(@RequestBody final MemberRequest memberRequest) {
	// 	memberService.join(memberRequest);
	// 	return "회원저장 성공!";
	// }
	//
	// @GetMapping("/{memberId}")
	// public String findMember(@PathVariable final Long memberId) {
	// 	Member member = memberService.findOne(memberId);
	// 	return "member 아이디: " + member.getId() + ", member 이름: " + member.getName();
	// }
	//

	/* MemberResponse dto 적용 */
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

	@GetMapping("/all")
	public List<MemberResponse> findMembers() {
		return memberService.findAll();
	}
}