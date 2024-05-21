package com.cow.mvc.post.repository;

import java.util.List;
import java.util.Optional;

import com.cow.mvc.post.entity.Post;

public interface PostRepository {

	void save(Post post);

	Optional<Post> findById(Long postId);

	Optional<List<Post>> findAll();
}
