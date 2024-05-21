package com.cow.cow_mvc_practice.member.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import com.cow.cow_mvc_practice.member.service.MemberService;

import jakarta.persistence.EntityNotFoundException;
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
	public MemberResponse findMemberQuery(@RequestParam("id") final Long memberId) {
		return memberService.findOne(memberId);
	}

	@GetMapping("/all")
	public List<MemberResponse> findMembers() {
		return memberService.findAll();
	}

	@PatchMapping(value = "/{memberId}")
	public MemberResponse update(@PathVariable final Long memberId,
		@RequestBody final UpdateMemberRequest updateMemberRequest) {
		return memberService.updateById(memberId, updateMemberRequest);
	}

	@DeleteMapping("/{memberId}")
	public ResponseEntity<Void> delete(@PathVariable final Long memberId) {
		return memberService.delete(memberId);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleNoSuchElementFoundException(EntityNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
}
