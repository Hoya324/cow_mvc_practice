package com.cow.cow_mvc_practice.member.service;

import static org.mockito.BDDMockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.repository.MemberJPARepository;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
	@InjectMocks
	MemberServiceImpl memberService;

	@Mock
	MemberJPARepository memberRepository;

	@Test
	@DisplayName("회원 불러오기")
	public void getMember() {
		Member member = Member.builder().id(1L).name("Test Member").build();

		given(memberRepository.findById(member.getId())).willReturn(Optional.of(member));

		ResponseEntity<MemberResponse> memberResponseEntity = memberService.findOne(member.getId());
		HttpStatusCode status = memberResponseEntity.getStatusCode();
		MemberResponse memberResponse = memberResponseEntity.getBody();
		Assertions.assertThat(status).isEqualTo(HttpStatus.OK);
		checkMember(memberResponse, member);
	}

	@Test
	@DisplayName("회원 전체 불러오기")
	public void getAllMember() {
		List<Member> members = new ArrayList<>();
		Member member1 = Member.builder().id(1L).name("Test Member1").build();
		Member member2 = Member.builder().id(2L).name("Test Member2").build();
		Member member3 = Member.builder().id(3L).name("Test Member3").build();
		members.add(member1);
		members.add(member2);
		members.add(member3);

		given(memberRepository.findAll()).willReturn(members);

		ResponseEntity<List<MemberResponse>> memberResponseEntity = memberService.findAll();
		HttpStatusCode status = memberResponseEntity.getStatusCode();
		List<MemberResponse> memberResponses = memberResponseEntity.getBody();
		Assertions.assertThat(status).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(memberResponses).isNotNull();
		checkMember(memberResponses.get(0), member1);
		checkMember(memberResponses.get(1), member2);
		checkMember(memberResponses.get(2), member3);
	}

	@Test
	@DisplayName("회원 저장")
	public void saveMember() {
		MemberRequest request = new MemberRequest("Test Member");
		Long memberId = 1L;
		Member member = Member.builder().id(memberId).name(request.getName()).build();

		given(memberRepository.save(any())).willReturn(member);

		ResponseEntity<MemberResponse> memberResponseEntity = memberService.join(request);
		HttpStatusCode status = memberResponseEntity.getStatusCode();
		MemberResponse memberResponse = memberResponseEntity.getBody();
		Assertions.assertThat(status).isEqualTo(HttpStatus.CREATED);
		checkMember(memberResponse, member);
	}

	@Test
	@DisplayName("회원 수정")
	public void updateMember() {
		MemberRequest request = new MemberRequest("Test Member");
		UpdateMemberRequest updateRequest = new UpdateMemberRequest("Update Member");
		Long memberId = 1L;
		Member member = Member.builder().id(memberId).name(request.getName()).build();
		Member updateMember = Member.builder().id(memberId).name(updateRequest.getName()).build();

		given(memberRepository.findById(memberId)).willReturn(Optional.of(member));

		ResponseEntity<MemberResponse> memberResponseEntity = memberService.updateById(memberId, updateRequest);
		HttpStatusCode status = memberResponseEntity.getStatusCode();
		MemberResponse memberResponse = memberResponseEntity.getBody();
		Assertions.assertThat(status).isEqualTo(HttpStatus.OK);
		checkMember(memberResponse, updateMember);
	}

	@Test
	@DisplayName("회원 이미지 수정")
	public void updateMemberImage() {
		MemberRequest request = new MemberRequest("Test Member");
		String imageLink = "Profile_Image_Link";
		Long memberId = 1L;
		Member member = Member.builder().id(memberId).name(request.getName()).build();

		given(memberRepository.findById(memberId)).willReturn(Optional.of(member));

		ResponseEntity<MemberResponse> memberResponseEntity = memberService.updateImageById(memberId, imageLink);
		HttpStatusCode status = memberResponseEntity.getStatusCode();
		MemberResponse memberResponse = memberResponseEntity.getBody();
		Assertions.assertThat(status).isEqualTo(HttpStatus.OK);
		checkMember(memberResponse, member);
		Assertions.assertThat(member.getProfileImage()).isEqualTo(imageLink);
	}

	@Test
	@DisplayName("회원 삭제")
	public void deleteMember() {
		Long memberId = 1L;

		given(memberRepository.existsById(memberId)).willReturn(true);

		ResponseEntity<Void> memberResponseEntity = memberService.delete(memberId);
		HttpStatusCode status = memberResponseEntity.getStatusCode();
		Assertions.assertThat(status).isEqualTo(HttpStatus.NO_CONTENT);
	}

	private void checkMember(MemberResponse memberResponse, Member member) {
		Assertions.assertThat(memberResponse).isNotNull();
		Assertions.assertThat(member.getId()).isEqualTo(memberResponse.getId());
		Assertions.assertThat(member.getName()).isEqualTo(memberResponse.getName());
		Assertions.assertThat(member.getPosts().size()).isEqualTo(memberResponse.getPosts().size());
		Assertions.assertThat(member.getProfileImage()).isEqualTo(memberResponse.getProfileImage());
	}
}
