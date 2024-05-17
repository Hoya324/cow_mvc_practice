package com.cow.cow_mvc_practice.post.controller.dto.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostRequest {
  Long id;
  final String title;
  final String content;

  public PostRequest() {
    this.title = "";
    this.content = "";
  }

  @Builder
  private PostRequest(final String title, final String content, final LocalDateTime date) {
    this.title = title;
    this.content = content;
  }
}
