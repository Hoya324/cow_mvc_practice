package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.repository.MemberJPARepository;
import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;
import com.cow.cow_mvc_practice.post.entity.Post;
import com.cow.cow_mvc_practice.post.repository.PostJPARepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService{

    private final PostJPARepository postRepository;
    private final MemberJPARepository memberRepository;
    @Override
    public PostResponse viewPost() {
        return null;
    }

    @Override
    public PostResponse findOne(Long postId) {
        return null;
    }

    @Override
    public PostResponse creatPost(Long memberId, PostRequest postRequest) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));
        Post post = Post.from(postRequest.getTitle(), postRequest.getContent(), member);
        postRepository.save(post);
        return PostResponse.from(post);
    }
}
