package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostCommentsResponse;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;

import java.util.List;

public interface PostService {

    PostResponse create(String memberName, PostRequest postRequest);

    PostResponse findOne(String postTitle);

    List<PostResponse> findAll(Long memberId);

    void deletePost(Long memberId, String content);

    PostCommentsResponse getPostComments(String title);

    int getCommentsAmount(String postTitle);
}
