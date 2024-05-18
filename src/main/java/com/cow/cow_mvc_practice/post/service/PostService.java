package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.post.controller.dto.request.CreatePostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.request.DeletePostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.CreatePostResponse;
import com.cow.cow_mvc_practice.post.controller.dto.response.DeletePostResponse;
import com.cow.cow_mvc_practice.post.controller.dto.response.FindPostResponse;

import java.util.List;

public interface PostService {

   CreatePostResponse createPost(CreatePostRequest createPostRequest);
   FindPostResponse findPost(Long postId);
   String delete(Long postId, DeletePostRequest deletePostRequest);
   List<CreatePostResponse> findAll();
}
