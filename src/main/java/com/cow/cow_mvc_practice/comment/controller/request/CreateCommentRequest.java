package com.cow.cow_mvc_practice.comment.controller.request;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateCommentRequest {
  private Long memberId;
  private Long postId;
  private String content;

  public static Comment toEntity(String content) {
    return Comment.builder()
        .content(content)
        .build();
  }

}
