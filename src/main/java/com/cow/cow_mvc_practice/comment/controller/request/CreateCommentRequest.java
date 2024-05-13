package com.cow.cow_mvc_practice.comment.controller.request;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import lombok.Getter;

@Getter
public class CreateCommentRequest {
  Long memberId;
  Long postId;
  String content;

  public Comment toEntity() {
    return Comment.builder()
        .content(content)
        .build();
  }

}
