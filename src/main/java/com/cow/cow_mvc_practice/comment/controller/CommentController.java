package com.cow.cow_mvc_practice.comment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cow.cow_mvc_practice.comment.controller.dto.request.CommentRequest;
import com.cow.cow_mvc_practice.comment.controller.dto.response.CommentResponse;
import com.cow.cow_mvc_practice.comment.service.CommentService;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Tag(name = "Comment", description = "댓글 관련 API")
@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
	private final CommentService commentService;

	@PostMapping("/new/member/{memberId}/post/{postId}")
	@Operation(summary = "등록", description = "신규 댓글 등록")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "등록 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))}),
		@ApiResponse(responseCode = "400", description = "잘못된 요청",
			content = {@Content(schema = @Schema(hidden = true))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 게시글 또는 회원",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public CommentResponse create(@PathVariable final Long memberId, @PathVariable final Long postId,
		@RequestBody final CommentRequest commentRequest) {
		return commentService.join(memberId, postId, commentRequest);
	}

	@GetMapping("/{commentId}")
	@Operation(summary = "조회", description = "기존 댓글 조회")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "조회 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 댓글",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public CommentResponse findMember(@PathVariable final Long commentId) {
		return commentService.findOne(commentId);
	}

	@GetMapping()
	@Operation(summary = "조회", description = "기존 댓글 조회")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "조회 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 댓글",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public CommentResponse findCommentQuery(@RequestParam("id") final Long commentId) {
		return commentService.findOne(commentId);
	}

	@GetMapping("all")
	@Operation(summary = "전체 조회", description = "모든 댓글 조회")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "조회 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))})
	})
	public List<CommentResponse> findComments() {
		return commentService.findAll();
	}

	@GetMapping("/all/member/{memberId}")
	@Operation(summary = "회원의 전체 댓글 조회", description = "특정 회원 ID로 작성된 모든 댓글 조회")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "조회 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 회원",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public List<CommentResponse> findCommentsByMember(@PathVariable final Long memberId) {
		return commentService.findAllByMember(memberId);
	}

	@GetMapping("/all/post/{postId}")
	@Operation(summary = "게시글의 전체 댓글 조회", description = "특정 게시글의 모든 댓글 조회")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "등록 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 게시글",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public List<CommentResponse> findCommentsByPost(@PathVariable final Long postId) {
		return commentService.findAllByPost(postId);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleNoSuchElementFoundException(EntityNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
}
