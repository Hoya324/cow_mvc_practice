package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;

public interface PostService {
    PostResponse viewPost();

    PostResponse findOne(Long postId);

    PostResponse creatPost(Long memberId, PostRequest postRequest);

}
