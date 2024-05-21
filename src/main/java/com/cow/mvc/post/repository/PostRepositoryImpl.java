package com.cow.mvc.post.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cow.mvc.post.entity.Post;

public class PostRepositoryImpl implements PostRepository {

	private static final Map<Long, Post> store = new HashMap<>();

	@Override
	public void save(Post post) {
		store.put(post.getId(), post);
	}

	@Override
	public Optional<Post> findById(Long memberId) {
		return Optional.ofNullable(store.get(memberId));
	}

	@Override
	public Optional<List<Post>> findAll() {
		return Optional.of((List<Post>)store.values());
	}
}
