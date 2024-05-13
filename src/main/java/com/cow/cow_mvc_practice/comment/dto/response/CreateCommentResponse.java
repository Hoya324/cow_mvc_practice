package com.cow.cow_mvc_practice.comment.dto.response;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateCommentResponse {
  private final Long id;
  private final String content;

  @Builder
  private CreateCommentResponse(Long id, String content) {
    this.id = id;
    this.content = content;
  }

  public static CreateCommentResponse from(final Comment comment) {
    return CreateCommentResponse.builder()
        .id(comment.getId())
        .content(comment.getContent())
        .build();
  }
}
