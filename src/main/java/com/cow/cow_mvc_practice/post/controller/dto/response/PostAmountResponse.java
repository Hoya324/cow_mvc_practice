package com.cow.cow_mvc_practice.post.controller.dto.response;

import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostAmountResponse {

    private final String memberName;
    private final Long postId;
    private final String title;
    private final String content;
    private final int commentAmount;

    @Builder
    private PostAmountResponse(final Long postId, final String title, final String content, final String memberName, final int commentAmount) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.memberName = memberName;
        this.commentAmount = commentAmount;
    }

    public static PostAmountResponse from(final Post post, int commentAmount) {
        return PostAmountResponse.builder()
                .memberName(post.getMember().getName())
                .postId(post.getId()) // builder 선언을 하였기에 사용 가능
                .title(post.getTitle())
                .content(post.getContent())
                .commentAmount(commentAmount)
                .build(); // builder 선언을 하였기에 사용 가능
    }
}
