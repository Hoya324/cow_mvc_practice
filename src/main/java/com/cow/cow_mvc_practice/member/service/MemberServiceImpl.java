package com.cow.cow_mvc_practice.member.service;

import java.util.List;
import java.util.stream.Collectors;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberCommentsResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.repository.MemberJPARepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service // Service Class에서 쓰인다. // 비즈니스 로직을 수행하는 Class라는 것을 나타내는 용도이다.
@RequiredArgsConstructor ////final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성
@Transactional //method 내부에서 일어나는 데이터베이스 로직이 전부 성공하게되거나 데이터베이스 접근중 하나라도 실패하면 다시 롤백할 수 있게 해주는 Annotation
public class MemberServiceImpl implements MemberService {

	private final MemberJPARepository memberRepository;
	// private final MemberRepository memberRepository;

	/* 기본 */
	// @Override
	// public void join(MemberRequest memberRequest) {
	// 	Member member = Member.from(memberRequest.getId(), memberRequest.getName());
	// 	memberRepository.save(member);
	// }
	//
	// @Transactional(readOnly = true)
	// @Override
	// public Member findOne(Long memberId) {
	// 	return memberRepository.findById(memberId)
	// 		.orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));
	// }

	/* MemberResponse dto 적용 */
	@Override
	public MemberResponse create(MemberRequest memberRequest) {
		Member member = memberRequest.toEntity();
		memberRepository.save(member);
		return MemberResponse.from(member);
	}

	@Transactional(readOnly = true) // ReadOnly -> 읽기 전용
	@Override
	public MemberResponse findOne(String memberName) {
		Member member = memberRepository.findByName(memberName)
			.orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));

		return MemberResponse.from(member);
	}

	@Transactional(readOnly = true) // ReadOnly -> 읽기 전용
	@Override
	public List<MemberResponse> findAll() {
		List<Member> members = memberRepository.findAll();

		return members.stream()
			.map(MemberResponse::from)
			.collect(Collectors.toList());
	}

	@Override
	public MemberResponse updateMemberInfo(UpdateMemberRequest updateMemberRequest) {
		Member member = memberRepository.findById(updateMemberRequest.getId())
				.orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));

		member.setName(updateMemberRequest.getName()); // 이름을 업데이트합니다.
		memberRepository.save(member); // 변경된 정보를 저장합니다.

		return MemberResponse.from(member); // 업데이트된 회원 정보를 반환합니다.
	}

	@Override
	public void deleteMember(Long memberId) {
		memberRepository.deleteById(memberId);
	}

	@Transactional(readOnly = true) // ReadOnly -> 읽기 전용
	@Override
	public MemberCommentsResponse getMemberComments(String name) {
		Member member = memberRepository.findByName(name)
				.orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));

		List<String> commentContents = member.getComments().stream()
				.map(Comment::getComment)  // 댓글 내용만 추출
				.toList();

		return MemberCommentsResponse.from(member, commentContents);
	}
}