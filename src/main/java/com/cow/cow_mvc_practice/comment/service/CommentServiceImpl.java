package com.cow.cow_mvc_practice.comment.service;

import com.cow.cow_mvc_practice.comment.controller.request.CreateCommentRequest;
import com.cow.cow_mvc_practice.comment.controller.response.CreateCommentResponse;
import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.comment.repository.CommentJPARepository;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.repository.MemberJPARepository;
import com.cow.cow_mvc_practice.post.entity.Post;
import com.cow.cow_mvc_practice.post.repository.PostJPARepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class CommentServiceImpl implements CommentService{
  private final CommentJPARepository commentRepository;
  private final MemberJPARepository memberRepository;
  private final PostJPARepository postRepository;

  @Override
  public CreateCommentResponse createComment(CreateCommentRequest createCommentRequest) {
    Member member = findMember(createCommentRequest.getMemberId());
    Post post = findPost(createCommentRequest.getPostId());

    Comment comment = Comment.of(createCommentRequest.getContent(), post, member);
    commentRepository.save(comment);
    post.addComment(comment);
    return CreateCommentResponse.from(comment);
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
