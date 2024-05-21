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

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {
private final PostJPARepository postRepository;
private final MemberJPARepository memberRepository;

    @Transactional(readOnly = true)
    @Override
    public PostResponse findOne(Long postID) {
        Post post = postRepository.findById(postID)
                .orElseThrow(() -> new EntityNotFoundException("[Error] 해당 게시글이 없습니다. id=" + postID));
        return PostResponse.from(post);
    }

    @Override
    public PostResponse make(PostRequest postRequest) {
        System.out.println(postRequest );
        Member member = findMember(postRequest.getMemberId());
        Post post = Post.of(postRequest.getTitle(), postRequest.getContent(), member,postRequest.toEntity().getCreatedAt());
        postRepository.save(post);
        return PostResponse.from(post);
    }

    @Override
    public List<PostResponse> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(PostResponse::from)
                .collect(Collectors.toList());
    }private Member findMember(Long memberId) {
        System.out.println(memberId);
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));
    }
    @Override
    @Transactional
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" + postId)
        );
        postRepository.delete(post);
    }
}
