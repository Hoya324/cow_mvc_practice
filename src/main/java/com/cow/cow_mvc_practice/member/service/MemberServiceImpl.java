package com.cow.cow_mvc_practice.member.service;

import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.CreateMemberResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cow.cow_mvc_practice.member.controller.dto.request.CreateMemberRequest;
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
	public CreateMemberResponse join(CreateMemberRequest createMemberRequest) {
		Member member = Member.from(createMemberRequest.getName());
		memberRepository.save(member);
		return CreateMemberResponse.from(member);
	}


	@Override
	public List<CreateMemberResponse> findAll() {
		List<Member> members = memberRepository.findAll();
		return members.stream()
			.map(CreateMemberResponse::from)
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public CreateMemberResponse findOne(Long memberId) {
		Member member = findMember(memberId);
		return CreateMemberResponse.from(member);
	}

	@Override
	public CreateMemberResponse update(Long memberId, UpdateMemberRequest updateMemberRequest) {
		Member member = findMember(memberId);
		member.updateName(updateMemberRequest.getName());
		return CreateMemberResponse.from(member);
	}

	private Member findMember(Long memberId) {
    return memberRepository.findById(memberId)
				.orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));
	}
}
