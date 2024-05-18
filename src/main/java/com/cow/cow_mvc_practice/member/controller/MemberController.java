package com.cow.cow_mvc_practice.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.cow.cow_mvc_practice.member.dto.request.CreateMemberRequest;
import com.cow.cow_mvc_practice.member.dto.response.MemberResponse;
import com.cow.cow_mvc_practice.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/new")
    public MemberResponse createMember(@RequestBody final CreateMemberRequest createMemberRequest) {
        return memberService.createMember(createMemberRequest);
    }

    @PatchMapping("/{memberId}")
    public MemberResponse update(@PathVariable("memberId") Long memberId, @RequestBody final CreateMemberRequest createMemberRequest) {
        return memberService.update(memberId, createMemberRequest.getName());
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
}

