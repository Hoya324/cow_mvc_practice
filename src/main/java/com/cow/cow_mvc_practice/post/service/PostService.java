package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;

public interface PostService {

    PostResponse join(Long id,String title,String content, Member member);
    Member postFindOne(Long memberId);
}

