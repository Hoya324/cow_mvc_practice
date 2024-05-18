package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface PostService {
  PostResponse findOne(Long postId);
  PostResponse join(Long memberId, PostRequest postRequest);
  List<PostResponse> findAll();
  List<PostResponse> findAllByMember(Long memberId);

  ResponseEntity<Void> delete(Long postId);
}