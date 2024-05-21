package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;
import com.cow.cow_mvc_practice.post.entity.Post;
import com.cow.cow_mvc_practice.post.repository.PostJPARepository;
import com.cow.cow_mvc_practice.member.repository.MemberJPARepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements  PostService{

    private final PostJPARepository postRepository;
    private final MemberJPARepository memberRepository;

    @Override
    public PostResponse join(Long id, String title, String content, Member member) {
        Post post = Post.from(title,content,member);
        postRepository.save(post);
        return PostResponse.from(post);
    }

    @Transactional(readOnly = true)
    @Override
    public Member postFindOne(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));
    }

}
