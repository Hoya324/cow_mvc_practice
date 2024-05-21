package com.cow.mvc.comment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cow.mvc.comment.controller.dto.request.CommentRequest;
import com.cow.mvc.comment.controller.dto.response.CommentResponse;
import com.cow.mvc.comment.entity.Comment;
import com.cow.mvc.comment.repository.CommentJPARepository;
import com.cow.mvc.member.entity.Member;
import com.cow.mvc.member.repository.MemberJPARepository;
import com.cow.mvc.post.entity.Post;
import com.cow.mvc.post.repository.PostJPARepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {
	private final CommentJPARepository commentRepository;
	private final MemberJPARepository memberRepository;
	private final PostJPARepository postRepository;

	@Transactional(readOnly = true)
	@Override
	public CommentResponse findOne(Long commentId) {
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new EntityNotFoundException("[Error] 댓글을 찾을 수 없습니다."));
		return CommentResponse.from(comment);
	}

	@Override
	public CommentResponse join(Long memberId, Long postId, CommentRequest commentRequest) {
		Member member = this.memberRepository.findById(memberId)
			.orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));
		Post post = this.postRepository.findById(postId)
			.orElseThrow(() -> new EntityNotFoundException("[Error] 게시글을 찾을 수 없습니다."));
		Comment comment = Comment.of(commentRequest.getContent(), LocalDateTime.now(), post, member);
		commentRepository.save(comment);
		return CommentResponse.from(comment);
	}

	@Transactional(readOnly = true)
	@Override
	public List<CommentResponse> findAllByPost(Long postId) {
		List<Comment> comments = commentRepository.findAllByPostId(postId);
		return comments.stream()
			.map(CommentResponse::from)
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public List<CommentResponse> findAllByMember(Long memberId) {
		List<Comment> comments = commentRepository.findAllByMemberId(memberId);
		return comments.stream()
			.map(CommentResponse::from)
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public List<CommentResponse> findAll() {
		List<Comment> comments = commentRepository.findAll();
		return comments.stream()
			.map(CommentResponse::from)
			.collect(Collectors.toList());
	}
}
