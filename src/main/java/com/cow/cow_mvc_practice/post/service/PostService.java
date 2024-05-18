package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.post.dto.request.CreatePostRequest;
import com.cow.cow_mvc_practice.post.dto.request.DeletePostRequest;
import com.cow.cow_mvc_practice.post.dto.response.CreatePostResponse;
import com.cow.cow_mvc_practice.post.dto.response.FindPostResponse;

import java.util.List;

public interface PostService {

   CreatePostResponse createPost(CreatePostRequest createPostRequest);
   FindPostResponse findPost(Long postId);
   String delete(Long postId, DeletePostRequest deletePostRequest);
   List<CreatePostResponse> findAll();
}
