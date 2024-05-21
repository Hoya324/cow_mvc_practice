package com.cow.cow_mvc_practice.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cow.cow_mvc_practice.comment.entity.Comment;

public interface CommentJPARepository extends JpaRepository<Comment, Long> {
	List<Comment> findAllByMemberId(Long memberId);

	List<Comment> findAllByPostId(Long postId);
}
