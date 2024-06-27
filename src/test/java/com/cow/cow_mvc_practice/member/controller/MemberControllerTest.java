package com.cow.cow_mvc_practice.member.controller;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import com.cow.cow_mvc_practice.Image.service.ImageUploadServiceImpl;
import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.service.MemberServiceImpl;

import jakarta.persistence.EntityNotFoundException;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	MemberServiceImpl memberService;
	@MockBean
	ImageUploadServiceImpl imageUploadService;

	@Test
	@DisplayName("회원 조회 테스트")
	void getMemberTest() throws Exception {
		Long memberId = 123L;

		Member member = Member.builder().id(memberId).name("Test Member").build();
		given(memberService.findOne(memberId)).willReturn(
			ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(MemberResponse.from(member)));

		mockMvc.perform(
				get("/member/" + memberId))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").exists())
			.andExpect(jsonPath("$.name").exists())
			.andExpect(jsonPath("$.profileImage").exists())
			.andExpect(jsonPath("$.posts").exists())
			.andDo(print());

		verify(memberService).findOne(memberId);
	}

	@Test
	@DisplayName("회원 조회 파라미터 테스트")
	void getMemberParameterTest() throws Exception {
		Long memberId = 123L;

		Member member = Member.builder().id(memberId).name("Test Member").build();
		given(memberService.findOne(memberId)).willReturn(
			ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(MemberResponse.from(member)));

		mockMvc.perform(
				get("/member?id=" + memberId))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").exists())
			.andExpect(jsonPath("$.name").exists())
			.andExpect(jsonPath("$.profileImage").exists())
			.andExpect(jsonPath("$.posts").exists())
			.andDo(print());

		verify(memberService).findOne(memberId);
	}

	@Test
	@DisplayName("존재하지 않는 회원 조회 테스트")
	void getMemberExceptionTest() throws Exception {
		Long memberId = 123L;
		given(memberService.findOne(memberId)).willThrow(new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));

		mockMvc.perform(
				get("/member/" + memberId))
			.andExpect(status().isNotFound())
			.andDo(print());

		verify(memberService).findOne(memberId);
	}

	@Test
	@DisplayName("회원 전체 조회 테스트")
	void getAllMemberTest() throws Exception {
		List<MemberResponse> memberResponses = new ArrayList<>();
		memberResponses.add(MemberResponse.from(Member.builder().id(123L).name("Test Member").build()));
		given(memberService.findAll()).willReturn(
			ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(memberResponses));

		mockMvc.perform(
				get("/member/all"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$..id").exists())
			.andExpect(jsonPath("$..name").exists())
			.andExpect(jsonPath("$..profileImage").exists())
			.andExpect(jsonPath("$..posts").exists())
			.andDo(print());

		verify(memberService).findAll();
	}

	@Test
	@DisplayName("회원 등록 테스트")
	void createMemberTest() throws Exception {
		MemberRequest memberRequest = new MemberRequest("Test Member");
		Member member = Member.builder().id(123L).name(memberRequest.getName()).build();

		given(memberService.join(any())).willReturn(
			ResponseEntity.status(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(MemberResponse.from(member))
		);

		String json = new ObjectMapper().writeValueAsString(memberRequest);

		mockMvc.perform(
				post("/member/new")
					.content(json)
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.id").exists())
			.andExpect(jsonPath("$.name").exists())
			.andExpect(jsonPath("$.profileImage").exists())
			.andExpect(jsonPath("$.posts").exists())
			.andDo(print());

		verify(memberService).join(any());
	}

	@Test
	@DisplayName("잘못된 회원 등록 테스트")
	void createMemberExceptionTest() throws Exception {
		MemberRequest memberRequest = new MemberRequest(null);

		given(memberService.join(any())).willThrow(new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));

		String json = new ObjectMapper().writeValueAsString(memberRequest);

		mockMvc.perform(
				post("/member/new")
					.content(json)
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isBadRequest())
			.andDo(print());

		verifyNoInteractions(memberService);
	}

	@Test
	@DisplayName("회원 삭제 테스트")
	void deleteMemberTest() throws Exception {
		Long memberId = 123L;

		given(memberService.delete(memberId)).willReturn(
			ResponseEntity.noContent().build());

		mockMvc.perform(
				delete("/member/" + memberId))
			.andExpect(status().isNoContent())
			.andDo(print());

		verify(memberService).delete(memberId);
	}

	@Test
	@DisplayName("회원 수정 테스트")
	void updateMemberTest() throws Exception {
		Long memberId = 123L;
		UpdateMemberRequest memberRequest = new UpdateMemberRequest("Update Member");
		Member member = Member.builder().id(memberId).name(memberRequest.getName()).build();

		given(memberService.updateById(any(), any())).willReturn(
			ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(MemberResponse.from(member)));

		String json = new ObjectMapper().writeValueAsString(memberRequest);

		mockMvc.perform(
				patch("/member/" + memberId)
					.content(json)
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").exists())
			.andExpect(jsonPath("$.name").exists())
			.andExpect(jsonPath("$.profileImage").exists())
			.andExpect(jsonPath("$.posts").exists())
			.andDo(print());

		verify(memberService).updateById(any(), any());
	}

	@Test
	@DisplayName("회원 프로필 사진 수정 테스트")
	void updateMemberImageTest() throws Exception {
		Long memberId = 123L;
		Member member = Member.builder().id(memberId).name("Test Member").build();
		MockMultipartFile imageFile = new MockMultipartFile(
			"image",
			"profile.png",
			MediaType.IMAGE_PNG_VALUE,
			"profile".getBytes()
		);
		String imageLink = imageFile.getOriginalFilename() + "_Image_Link";
		given(imageUploadService.upload(any())).willReturn(
			imageLink);

		member.updateProfileImage(imageLink);
		given(memberService.updateImageById(any(), any())).willReturn(
			ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(MemberResponse.from(member)));

		mockMvc.perform(
				multipart(HttpMethod.PATCH, "/member/" + memberId + "/image")
					.file(imageFile))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").exists())
			.andExpect(jsonPath("$.name").exists())
			.andExpect(jsonPath("$.profileImage").exists())
			.andExpect(jsonPath("$.posts").exists())
			.andDo(print());

		verify(imageUploadService).upload(any());
		verify(memberService).updateImageById(any(), any());
	}
}
