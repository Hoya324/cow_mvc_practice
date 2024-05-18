package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.repository.MemberJPARepository;
import com.cow.cow_mvc_practice.post.controller.dto.request.CreatePostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.CreatePostResponse;
import com.cow.cow_mvc_practice.post.entity.Post;
import com.cow.cow_mvc_practice.post.repository.PostJPARepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {
    private final PostJPARepository postJPARepository;
    private final MemberJPARepository memberJPARepository;

    @Override
    public CreatePostResponse createPost(CreatePostRequest createPostRequest) {
        Member member = findMember(createPostRequest.getId());
        Post post = createPostRequest.toEntity(member);
        postJPARepository.save(post);
        return CreatePostResponse.from(post);
    }

    @Override
    public CreatePostResponse findPost(Long postId) {
        Post post = postJPARepository.findById(postId).orElseThrow(() ->
                new EntityNotFoundException("게시글이 존재하지 않습니다."));
        return CreatePostResponse.from(post);
    }

    @Override
    public List<CreatePostResponse> findAll() {
        List<Post> posts = postJPARepository.findAll();
        return posts.stream()
                .map(CreatePostResponse::from)
                .collect(Collectors.toList());
    }

    private Member findMember(Long memberId) {
        return memberJPARepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다."));
    }
}
