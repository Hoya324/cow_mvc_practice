package com.cow.cow_mvc_practice.comment.repository;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Override
    Optional<Comment> findById(Long commentId);
}
