package com.cow.cow_mvc_practice.post.controller.dto.response;

import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreatePostResponse {
  private final Long id;
  private final String title;
  private final String content;
  private final String memberName;
  private final int commentSize;

  @Builder
  private CreatePostResponse(Long id, String title, String content, String memberName, int commentSize) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.memberName = memberName;
    this.commentSize = commentSize;
  }

  public static CreatePostResponse from(final Post post) {
    return CreatePostResponse.builder()
        .id(post.getId())
        .title(post.getTitle())
        .content(post.getContent())
        .memberName(post.getMemberName())
        .commentSize(post.getComments().size())
        .build();
  }
}
