package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.member.service.MemberService;
import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.request.UpdatePostRequest;
import com.cow.cow_mvc_practice.post.entity.Post;
import com.cow.cow_mvc_practice.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final MemberService memberService;

    public Post save(PostRequest postRequest, Long memberId) {
        Post post = postRequest.toEntity(memberService.findMember(memberId));
        return postRepository.save(post);
    }

    public Post findPost(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found : " + id));
    }

    @Transactional
    public Post update(long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found : " + id));

        post.update(request.getTitle(), request.getContent());

        return post;
    }
}
