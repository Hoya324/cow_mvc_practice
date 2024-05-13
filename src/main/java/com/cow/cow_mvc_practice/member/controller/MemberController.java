package com.cow.cow_mvc_practice.member.controller;

import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.CreateMemberResponse;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cow.cow_mvc_practice.member.controller.dto.request.CreateMemberRequest;
import com.cow.cow_mvc_practice.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/new")
	public CreateMemberResponse create(@RequestBody final CreateMemberRequest createMemberRequest) {
		return memberService.join(createMemberRequest);
	}

	@GetMapping("/{memberId}")
	public CreateMemberResponse findMember(@PathVariable final Long memberId) {
		return memberService.findOne(memberId);
	}

	@GetMapping()
	public CreateMemberResponse findMemberQuery(@RequestParam final Long memberId) {
		return memberService.findOne(memberId);
	}

	@GetMapping("/all")
	public List<CreateMemberResponse> findMembers() {
		return memberService.findAll();
	}

	@PostMapping("/{memberId}")
	public CreateMemberResponse editMember(@PathVariable final Long memberId, final UpdateMemberRequest updateMemberRequest) {
		return memberService.update(memberId, updateMemberRequest);
	}
}

