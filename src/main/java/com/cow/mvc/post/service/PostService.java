package com.cow.mvc.post.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cow.mvc.post.controller.dto.request.PostRequest;
import com.cow.mvc.post.controller.dto.response.PostResponse;

public interface PostService {
	PostResponse findOne(Long postId);

	PostResponse join(Long memberId, PostRequest postRequest);

	List<PostResponse> findAll();

	List<PostResponse> findAllByMember(Long memberId);

	ResponseEntity<Void> delete(Long postId);
}
