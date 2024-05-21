package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostAmountResponse;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostCommentsResponse;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;

import java.util.List;

public interface PostService {

    PostResponse create(String memberName, PostRequest postRequest);

    PostAmountResponse findOne(String postTitle);

    void deletePost(String title);

    PostCommentsResponse getPostComments(String title);

}
