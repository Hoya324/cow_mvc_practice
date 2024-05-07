package com.cow.cow_mvc_practice.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cow.cow_mvc_practice.member.controller.dto.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.MemberResponse;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	//    private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final MemberRepository memberRepository;

	@Autowired
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	// @Override
	// public void join(MemberRequest memberRequest) {
	// 	Member member = new Member(memberRequest.getId(), memberRequest.getName());
	// 	memberRepository.save(member);
	// }

	@Override
	public MemberResponse join(MemberRequest memberRequest) {
		Member member = new Member(memberRequest.getId(), memberRequest.getName());
		memberRepository.save(member);
		return MemberResponse.of(member);
	}

	// @Override
	// public Member findOne(Long memberId) {
	// 	return memberRepository.findById(memberId)
	// 		.orElseThrow(() -> new IllegalArgumentException("[Error] 사용자를 찾을 수 없습니다."));
	// }

	@Override
	public MemberResponse findOne(Long memberId) {
		Member member = memberRepository.findById(memberId)
			.orElseThrow(() -> new IllegalArgumentException("[Error] 사용자를 찾을 수 없습니다."));
		return MemberResponse.of(member);
	}
}