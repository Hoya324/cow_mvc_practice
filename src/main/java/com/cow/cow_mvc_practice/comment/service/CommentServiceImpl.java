package com.cow.cow_mvc_practice.comment.service;

import com.cow.cow_mvc_practice.comment.dto.request.CreateCommentRequest;
import com.cow.cow_mvc_practice.comment.dto.response.CreatedCommentResponse;
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

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

	private final MemberJPARepository memberJPARepository;
	private final PostJPARepository postJPARepository;
	private final CommentJPARepository commentJPARepository;

	@Override
	public CreatedCommentResponse create(Long postId, CreateCommentRequest createCommentRequest) {
		Member member = findMember(createCommentRequest);
		Post post = findPost(postId);
		Comment comment = createCommentRequest.toEntity(member, post);
		commentJPARepository.save(comment);
		return CreatedCommentResponse.from(comment);
	}

	private Post findPost(Long postId) {
		return postJPARepository.findById(postId)
				.orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
	}

	private Member findMember(CreateCommentRequest createCommentRequest) {
		return memberJPARepository.findById(createCommentRequest.getId())
				.orElseThrow(() -> new EntityNotFoundException("사용자를 찾을 수 없습니다."));
	}
}