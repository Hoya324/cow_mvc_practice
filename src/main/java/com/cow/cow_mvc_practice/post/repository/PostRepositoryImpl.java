package com.cow.cow_mvc_practice.post.repository;


import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PostRepositoryImpl implements PostRepository {
    private static Map<Long, Post> posts = new HashMap<>();

    @Override
    public void save(Long postId,Post post) {
        posts.put(post.getId(), post);
    }

    @Override
    public Optional<Post> findById(Long postId) {
        return Optional.ofNullable(posts.get(postId));
    }

}
