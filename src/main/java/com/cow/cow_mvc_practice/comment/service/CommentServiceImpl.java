package com.cow.cow_mvc_practice.comment.service;

import com.cow.cow_mvc_practice.comment.dto.request.CommentRequest;
import com.cow.cow_mvc_practice.comment.dto.response.CommentResponse;
import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.comment.repository.CommentJPARepository;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.repository.MemberJPARepository;
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
public class CommentServiceImpl implements CommentService {

	private final MemberJPARepository memberJPARepository;
	private final PostJPARepository postJPARepository;
	private final CommentJPARepository commentJPARepository;

	@Override
	public CommentResponse createComment(Long postId, CommentRequest commentRequest) {
		Member member = memberJPARepository.findById(commentRequest.getId())
				.orElseThrow(() -> new EntityNotFoundException("사용자를 찾을 수 없습니다."));
		Post post = postJPARepository.findById(postId)
				.orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
		Comment comment = commentRequest.toEntity(member, post);
		commentJPARepository.save(comment);
		return CommentResponse.from(comment);
	}
}