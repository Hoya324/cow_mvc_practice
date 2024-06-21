package com.cow.cow_mvc_practice.post.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;
import com.cow.cow_mvc_practice.post.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Tag(name = "Post", description = "게시글 관련 API")
@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;

	@PostMapping("/new/member/{memberId}")
	@Operation(summary = "등록", description = "신규 게시글 등록")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "등록 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))}),
		@ApiResponse(responseCode = "400", description = "잘못된 요청",
			content = {@Content(schema = @Schema(hidden = true))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 회원",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public PostResponse create(@PathVariable final Long memberId, @RequestBody final PostRequest postRequest) {
		return postService.join(memberId, postRequest);
	}

	@GetMapping("/{postId}")
	@Operation(summary = "조회", description = "기존 게시글 조회")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "조회 성공",
			content = {@Content(schema = @Schema(implementation = PostResponse.class))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 게시글",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public PostResponse findPost(@PathVariable final Long postId) {
		return postService.findOne(postId);
	}

	@GetMapping()
	@Operation(summary = "조회", description = "기존 게시글 조회")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "조회 성공",
			content = {@Content(schema = @Schema(implementation = PostResponse.class))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 게시글",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public PostResponse findPostQuery(@RequestParam("id") final Long postId) {
		return postService.findOne(postId);
	}

	@GetMapping("/all")
	@Operation(summary = "전체 조회", description = "모든 게시글 조회")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "조회 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))})
	})
	public List<PostResponse> findPosts() {
		return postService.findAll();
	}

	@GetMapping("/all/member/{memberId}")
	@Operation(summary = "회원의 전체 게시글 조회", description = "특정 회원 ID로 작성된 모든 게시글 조회")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "조회 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 회원",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public List<PostResponse> findPostsByMember(@PathVariable final Long memberId) {
		return postService.findAllByMember(memberId);
	}

	@DeleteMapping("/{postId}")
	@Operation(summary = "삭제", description = "기존 게시글 삭제")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "204", description = "삭제 성공",
			content = {@Content(schema = @Schema(implementation = MemberResponse.class))}),
		@ApiResponse(responseCode = "404", description = "존재하지 않는 게시글",
			content = {@Content(schema = @Schema(hidden = true))})
	})
	public ResponseEntity<Void> deletePost(@PathVariable final Long postId) {
		return postService.delete(postId);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleNoSuchElementFoundException(EntityNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
}
