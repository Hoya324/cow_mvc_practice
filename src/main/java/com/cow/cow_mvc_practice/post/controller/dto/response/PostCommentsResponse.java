package com.cow.cow_mvc_practice.post.controller.dto.response;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostCommentsResponse {

    private final String postTitle;
    private final List<String> commentContents;

    @Builder // 어느 필드에 어떤 값을 채워야 할지 명확하게 정하여 생성 시점에 값을 채워준다.
    private PostCommentsResponse(String postTitle, List<String> postComments) {
        this.postTitle = postTitle;
        this.commentContents = postComments;
    }

    public static PostCommentsResponse from(final Post post, List<String> commentContents) {
        return PostCommentsResponse.builder()
                .postTitle(post.getTitle())
                .postComments(commentContents)
                .build();
    }
}
