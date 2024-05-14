package com.cow.cow_mvc_practice.post.controller.dto.request;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class PostRequest {

    String title;

    String content;

}
