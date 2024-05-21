package com.cow.cow_mvc_practice.member.controller;

import java.util.List;

import com.cow.cow_mvc_practice.comment.controller.dto.response.CommentResponse;
import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberCommentsResponse;
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

	@PostMapping("/new")
	public MemberResponse create(@RequestBody final MemberRequest memberRequest) {
		return memberService.create(memberRequest);
	}

	@GetMapping("/{memberName}")
	public MemberResponse findMember(@PathVariable final String memberName) {
		return memberService.findOne(memberName);
	}

	@GetMapping("/")
	public MemberResponse findMemberQuery(@RequestParam final String name) {
		return memberService.findOne(name);
	}

	@GetMapping("/all")
	public List<MemberResponse> findMembers() {
		return memberService.findAll();
	}

	@PutMapping("/update")
	public MemberResponse updateMember(@RequestBody UpdateMemberRequest memberRequest) {
		return memberService.updateMemberInfo(memberRequest);
	}

	@DeleteMapping("/delete")
	public void deleteMember(@RequestParam final String memberName) {
		memberService.deleteMember(memberName);
	}

	@GetMapping("/comments")
	public MemberCommentsResponse getMemberComments(@RequestParam final String name) {
		return memberService.getMemberComments(name);
	}
}

