package com.cow.cow_mvc_practice.post.repository;

import com.cow.cow_mvc_practice.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJPARepository extends JpaRepository<Post, Long> {

}
