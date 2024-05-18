package com.cow.cow_mvc_practice.member.service;

import java.util.List;
import java.util.stream.Collectors;

import com.cow.cow_mvc_practice.member.dto.request.CreateMemberRequest;
import com.cow.cow_mvc_practice.member.dto.request.UpdateMemberRequest;
import com.cow.cow_mvc_practice.member.dto.response.FindMemberResponse;
import com.cow.cow_mvc_practice.member.dto.response.UpdateMemberResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cow.cow_mvc_practice.member.dto.response.CreateMemberResponse;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.repository.MemberJPARepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberJPARepository memberRepository;

    @Override
    public CreateMemberResponse createMember(CreateMemberRequest createMemberRequest) {
        Member member = createMemberRequest.toEntity();
        memberRepository.save(member);
        return CreateMemberResponse.from(member);
    }

    @Override
    public UpdateMemberResponse update(Long memberId, UpdateMemberRequest updateMemberRequest) {
        Member member = findById(memberId);
        updateMemberRequest.updateEntity(member);
        memberRepository.save(member);
        return UpdateMemberResponse.from(member);
    }

    @Transactional(readOnly = true)
    @Override
    public FindMemberResponse findMember(Long memberId) {
        Member member = findById(memberId);
        return FindMemberResponse.from(member);
    }

    @Transactional(readOnly = true)
    @Override
    public List<FindMemberResponse> findAll() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(FindMemberResponse::from)
                .collect(Collectors.toList());
    }

    private Member findById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));
    }
}