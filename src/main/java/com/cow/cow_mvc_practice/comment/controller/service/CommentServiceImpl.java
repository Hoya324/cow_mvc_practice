package com.cow.cow_mvc_practice.comment.controller.service;

import com.cow.cow_mvc_practice.comment.controller.dto.request.CommentDeleteRequest;
import com.cow.cow_mvc_practice.comment.controller.dto.request.CommentRequest;
import com.cow.cow_mvc_practice.comment.controller.dto.response.CommentResponse;
import com.cow.cow_mvc_practice.comment.controller.repository.CommentJPARepository;
import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.repository.MemberJPARepository;
import com.cow.cow_mvc_practice.post.entity.Post;
import com.cow.cow_mvc_practice.post.repository.PostJPARepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentJPARepository commentRepository;
    private final MemberJPARepository memberRepository;
    private final PostJPARepository postRepository;

    @Override
    public CommentResponse create(CommentRequest commentRequest) {
        Member member = memberRepository.findByName(commentRequest.getMemberName())
                .orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));

        Post post = postRepository.findByTitle(commentRequest.getPostTitle())
                .orElseThrow(() -> new EntityNotFoundException("[Error] 게시글을 찾을 수 없습니다."));

        Comment comment = commentRequest.toEntity(member, post);
        commentRepository.save(comment);

        return CommentResponse.from(comment);
    }

    @Override
    public boolean delete(String name, String title, CommentDeleteRequest request) {
        Member member = memberRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));

        Post post = postRepository.findByTitle(title)
                .orElseThrow(() -> new EntityNotFoundException("[Error] 게시글을 찾을 수 없습니다."));

        Comment comment = commentRepository.findByMemberNameAndPostTitleAndComment(member.getName(), post.getTitle(), request.getContent())
                .orElseThrow(() -> new EntityNotFoundException("[Error] 댓글을 찾을 수 없습니다."));

        commentRepository.delete(comment);

        return true;
    }

}
