package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.member.controller.dto.response.CreateMemberResponse;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.repository.MemberJPARepository;
import com.cow.cow_mvc_practice.member.service.MemberService;
import com.cow.cow_mvc_practice.post.controller.dto.request.CreatePostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.CreatePostResponse;
import com.cow.cow_mvc_practice.post.entity.Post;
import com.cow.cow_mvc_practice.post.repository.PostJPARepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

  private final PostJPARepository postRepository;
  private final MemberJPARepository memberRepository;

  @Override
  public CreatePostResponse createPost(CreatePostRequest createPostRequest) {
    Member member = findMember(createPostRequest.getMemberId());
    Post post = Post.of(createPostRequest.getTitle(), createPostRequest.getContent(), member);
    postRepository.save(post);
    return CreatePostResponse.from(post);
  }

  @Transactional(readOnly = true)
  @Override
  public CreatePostResponse findOnePost(Long postId) {
    Post post = findPost(postId);
    return CreatePostResponse.from(post);
  }

  @Override
  public List<CreatePostResponse> findAllPost() {
    List<Post> posts = postRepository.findAll();
    return posts.stream()
        .map(CreatePostResponse::from)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Long postId) {
    Post post = findPost(postId);
    postRepository.delete(post);
  }

  private Post findPost(Long postId) {
    return postRepository.findById(postId)
        .orElseThrow(() -> new EntityNotFoundException("[Error] 게시글를 찾을 수 없습니다."));
  }

  private Member findMember(Long memberId) {
    return memberRepository.findById(memberId)
        .orElseThrow(() -> new EntityNotFoundException("[Error] 회원를 찾을 수 없습니다."));
  }
}
