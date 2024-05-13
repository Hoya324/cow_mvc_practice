package com.cow.cow_mvc_practice.post.controller.dto.request;

import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Getter;

@Getter
public class CreatePostRequest {
   Long memberId;
   String title;
   String content;

  public Post toEntity() {
    return Post.builder()
        .title(title)
        .content(content)
        .build();
  }
}
