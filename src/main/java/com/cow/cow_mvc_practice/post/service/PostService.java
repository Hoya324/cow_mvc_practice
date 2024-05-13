package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.post.dto.request.CreatePostRequest;
import com.cow.cow_mvc_practice.post.dto.response.CreatePostResponse;
import java.util.List;

public interface PostService {

  CreatePostResponse createPost(CreatePostRequest postRequest);

  CreatePostResponse findOnePost(Long postId);

  List<CreatePostResponse> findAllPost();

  void delete(Long postId);
}
