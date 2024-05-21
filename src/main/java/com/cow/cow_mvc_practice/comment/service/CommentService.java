package com.cow.cow_mvc_practice.comment.service;

import com.cow.cow_mvc_practice.comment.controller.dto.request.CommentRequest;
import com.cow.cow_mvc_practice.comment.controller.dto.request.UpdateCommentRequest;
import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.comment.repository.CommentRepository;
import com.cow.cow_mvc_practice.member.service.MemberService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberService memberService;

    public Comment save(CommentRequest commentRequest, Long memberId) {
        Comment comment = CommentRequest.toEntity(memberService.findOne(memberId));
        return commentRepository.save(comment);
    }

    public Comment findComment(long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found : " + id));
    }

    @Transactional
    public Comment update(long id, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        comment.update(request.getTitle(), request.getComment());

        return comment;
    }
}
