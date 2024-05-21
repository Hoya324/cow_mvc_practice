package com.cow.cow_mvc_practice.post.repository;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostJPARepository extends JpaRepository<Post, Long> {

    Optional<Post> findByTitle(String title);
}
