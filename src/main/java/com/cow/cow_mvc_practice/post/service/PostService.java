package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;

import java.util.List;

public interface PostService {
    PostResponse findOne(Long postID);
    PostResponse make(PostRequest postRequest);
    List<PostResponse> findAll();
    void deletePost(Long postId);
}
