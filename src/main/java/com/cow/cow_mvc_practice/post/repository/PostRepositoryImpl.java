package com.cow.cow_mvc_practice.post.repository;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private static Map<Long, Post> store = new HashMap<>();
    @Override
    public void save(Post post) {
        store.put(post.getId(), post);
    }

    @Override
    public Optional<Post> findByID(Long postId) {
        return Optional.ofNullable(store.get(postId));
    }

    @Override
    public Optional<List<Post>> findAll() {
        return Optional.of((List<Post>)store.values());
    }
}
