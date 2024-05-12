package com.cow.cow_mvc_practice.member.service;

import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
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
	public MemberResponse join(MemberRequest memberRequest) {
		Member member = Member.from(memberRequest.getName());
		memberRepository.save(member);
		return MemberResponse.from(member);
	}


	@Override
	public List<MemberResponse> findAll() {
		List<Member> members = memberRepository.findAll();
		return members.stream()
			.map(MemberResponse::from)
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public MemberResponse findOne(Long memberId) {
		Member member = findMemberById(memberId);
		return MemberResponse.from(member);
	}

	@Override
	public MemberResponse update(Long memberId, UpdateMemberRequest updateMemberRequest) {
		Member member = findMemberById(memberId);
		member.updateName(updateMemberRequest.getName());
		return MemberResponse.from(member);
	}

	private Member findMemberById(Long memberId) {
    return memberRepository.findById(memberId)
				.orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));
	}
}