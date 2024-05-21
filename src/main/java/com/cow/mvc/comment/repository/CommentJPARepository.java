package com.cow.mvc.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cow.mvc.comment.entity.Comment;

public interface CommentJPARepository extends JpaRepository<Comment, Long> {
	List<Comment> findAllByMemberId(Long memberId);

	List<Comment> findAllByPostId(Long postId);
}
