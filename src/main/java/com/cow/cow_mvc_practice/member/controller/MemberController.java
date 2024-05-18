package com.cow.cow_mvc_practice.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import com.cow.cow_mvc_practice.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	/* MemberResponse dto 적용 */
	@PostMapping("/new")
	public MemberResponse createMember(@RequestBody final MemberRequest memberRequest) {
		return memberService.join(memberRequest.getName());
	}

//	@PatchMapping("/{memberId}")
//	public MemberResponse update(@PathVariable("memberId") String memberId, @RequestBody final MemberRequest memberRequest) {
//
//		return memberService.
//	}

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
}

