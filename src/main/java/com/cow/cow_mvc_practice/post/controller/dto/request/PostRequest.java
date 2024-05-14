package com.cow.cow_mvc_practice.post.controller.dto.request;

import com.cow.cow_mvc_practice.post.entity.Post;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@AllArgsConstructor
public class PostRequest {
  Long id;
  final String title;
  final String content;
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  final LocalDateTime date;

  public PostRequest() {
    this.title = "";
    this.content = "";
    this.date = LocalDateTime.now();
  }

  @Builder
  private PostRequest(final String title, final String content, final LocalDateTime date) {
    this.title = title;
    this.content = content;
    this.date = date;
  }

  public static Post toEntity(String title, String content, LocalDateTime date) {
    return Post.of(title, content, date);
  }
}
