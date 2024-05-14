package com.cow.cow_mvc_practice.post.controller.dto.request;

import com.cow.cow_mvc_practice.member.entity.Member;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

public class UpdatePostRequest {

  private String title;
  private String content;
  private Member member;
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime date;
}
