package com.cow.cow_mvc_practice.member.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cow.cow_mvc_practice.Image.service.ImageUploadService;
import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import com.cow.cow_mvc_practice.member.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@Tag(name = "Member", description = "회원 관련 API")
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	private final ImageUploadService imageUploadService;

	@PostMapping("/new")
	@Operation(summary = "등록", description = "신규 회원 등록")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = "등록 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))}),
		@ApiResponse(responseCode = "400", description = "잘못된 요청")
	})
	public ResponseEntity<MemberResponse> create(@Valid @RequestBody final MemberRequest memberRequest) {
		return memberService.join(memberRequest);
	}

	@GetMapping("/{memberId}")
	@Operation(summary = "조회", description = "기존 회원 조회")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "조회 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 회원",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public ResponseEntity<MemberResponse> findMember(@PathVariable final Long memberId) {
		return memberService.findOne(memberId);
	}

	@GetMapping()
	@Operation(summary = "조회", description = "기존 회원 조회")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "조회 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 회원",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public ResponseEntity<MemberResponse> findMemberQuery(@RequestParam("id") final Long memberId) {
		return memberService.findOne(memberId);
	}

	@GetMapping("/all")
	@Operation(summary = "전체 조회", description = "모든 회원 조회")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "조회 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))})
	})
	public ResponseEntity<List<MemberResponse>> findMembers() {
		return memberService.findAll();
	}

	@PatchMapping(value = "/{memberId}")
	@Operation(summary = "수정", description = "기존 회원 수정")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "수정 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 회원",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public ResponseEntity<MemberResponse> update(@PathVariable final Long memberId,
		@Valid @RequestBody final UpdateMemberRequest updateMemberRequest) {
		return memberService.updateById(memberId, updateMemberRequest);
	}

	@PatchMapping(value = "/{memberId}/image")
	@Operation(summary = "프로필 사진 수정", description = "기존 회원 프로필 사진 수정")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "프로필 사진 수정 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 회원",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public ResponseEntity<MemberResponse> updateProfileImage(@PathVariable final Long memberId,
		@RequestParam("image") MultipartFile multipartFile) throws IOException {
		String profileImage = imageUploadService.upload(multipartFile);
		return memberService.updateImageById(memberId, profileImage);
	}

	@DeleteMapping("/{memberId}")
	@Operation(summary = "삭제", description = "기존 회원 삭제")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "204", description = "삭제 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 회원",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public ResponseEntity<Void> delete(@PathVariable final Long memberId) {
		return memberService.delete(memberId);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("잘못된 요청입니다.");
	}
}
