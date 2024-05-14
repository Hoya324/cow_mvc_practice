package com.cow.cow_mvc_practice.post.controller.dto.response;

import com.cow.cow_mvc_practice.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponse {
  private final Long id;

  private final String title;

  private final String content;

  private final String memberName;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
  final LocalDateTime date;

  @Builder
  private PostResponse(final Long id, final String title, final String content, final String memberName, final LocalDateTime date) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.memberName = memberName;
    this.date = date;
  }

  public static PostResponse from(final Post post) {
    return PostResponse.builder()
        .id(post.getId())
        .title(post.getTitle())
        .content(post.getContent())
        .memberName(post.getMember().getName())
        .date(post.getDate())
        .build();
  }
}
