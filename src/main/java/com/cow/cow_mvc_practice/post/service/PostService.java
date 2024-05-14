package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;

import java.util.List;

public interface PostService {

    PostResponse join(Long memberId, String title, String content);

    PostResponse findOne(Long postId);

    List<PostResponse> findAll(Long memberId);
    void deletePost(Long memberId, String content);
}
