package com.cow.cow_mvc_practice.post.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdatePostRequest {
    private String title;
    private String content;
}
