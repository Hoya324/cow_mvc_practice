package com.cow.cow_mvc_practice.post.repository;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    void save(Post post);
    Optional<Post> findByID(Long postId);

    Optional<List<Post>> findAll();

}
