package com.cow.cow_mvc_practice.comment.repository;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJPARepository extends JpaRepository<Comment, Long> {

    int countByPostId(Long id);
}
