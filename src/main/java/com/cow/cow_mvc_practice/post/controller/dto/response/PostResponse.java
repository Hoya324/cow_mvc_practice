package com.cow.cow_mvc_practice.post.controller.dto.response;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.sql.Time;

@Getter
public class PostResponse {

    private final String memberName;
    private final Long postId;
    private final String title;
    private final String content;

    @Builder // 어느 필드에 어떤 값을 채워야 할지 명확하게 정하여 생성 시점에 값을 채워준다.
    private PostResponse(final Long postId, final String title, final String content, final String memberName) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.memberName = memberName;
    }

    public static PostResponse from(final Post post) {
        return PostResponse.builder()
                .memberName(post.getMember().getName())
                .postId(post.getId()) // builder 선언을 하였기에 사용 가능
                .title(post.getTitle())
                .content(post.getContent())
                .build(); // builder 선언을 하였기에 사용 가능
    }
}
