package com.cow.cow_mvc_practice.post.repository;

import com.cow.cow_mvc_practice.post.entity.Post;

import java.util.Optional;

public interface PostRepository {
    void save(Long postId,Post post);

    Optional<Post> findById(Long postId);

}
