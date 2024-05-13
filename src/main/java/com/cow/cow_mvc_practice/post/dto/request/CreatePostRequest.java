package com.cow.cow_mvc_practice.post.dto.request;

import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Getter;

@Getter
public class CreatePostRequest {
   private Long memberId;
   private String title;
   private String content;

  public static Post toEntity(String title, String content) {
    return Post.builder()
        .title(title)
        .content(content)
        .build();
  }
}
