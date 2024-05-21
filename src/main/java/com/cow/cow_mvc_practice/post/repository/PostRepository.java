package com.cow.cow_mvc_practice.post.repository;

import com.cow.cow_mvc_practice.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBy();

    @Override
    Optional<Post> findById(Long postId);
}
