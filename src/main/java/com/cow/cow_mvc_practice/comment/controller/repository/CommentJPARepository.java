package com.cow.cow_mvc_practice.comment.controller.repository;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentJPARepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findByMemberNameAndPostTitleAndComment(String memberName, String postTitle, String comment);

    void deleteById(Long id);

}
