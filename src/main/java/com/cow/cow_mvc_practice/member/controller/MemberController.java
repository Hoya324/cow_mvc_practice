package com.cow.cow_mvc_practice.member.controller;

import java.util.List;

import com.cow.cow_mvc_practice.member.dto.request.UpdateMemberRequest;
import com.cow.cow_mvc_practice.member.dto.response.FindMemberResponse;
import com.cow.cow_mvc_practice.member.dto.response.UpdateMemberResponse;
import org.springframework.web.bind.annotation.*;
import com.cow.cow_mvc_practice.member.dto.request.CreateMemberRequest;
import com.cow.cow_mvc_practice.member.dto.response.CreateMemberResponse;
import com.cow.cow_mvc_practice.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/new")
    public CreateMemberResponse create(@RequestBody final CreateMemberRequest createMemberRequest) {
        return memberService.create(createMemberRequest);
    }

    @PatchMapping("/{memberId}")
    public UpdateMemberResponse update(@PathVariable("memberId") Long memberId, @RequestBody final UpdateMemberRequest updateMemberRequest) {
        return memberService.update(memberId, updateMemberRequest);
    }

    @GetMapping("/{memberId}")
    public FindMemberResponse find(@PathVariable final Long memberId) {
        return memberService.find(memberId);
    }

    @GetMapping("/all")
    public List<FindMemberResponse> findAll() {
        return memberService.findAll();
    }
}

