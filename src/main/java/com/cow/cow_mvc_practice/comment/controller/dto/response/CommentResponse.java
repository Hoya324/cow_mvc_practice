package com.cow.cow_mvc_practice.comment.controller.dto.response;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import lombok.Builder;
import lombok.Getter;

import java.sql.Time;

@Getter
public class CommentResponse {
    private final String memberName;
    private final String title;
    private final String content;
    private final String comment;

    @Builder // 어느 필드에 어떤 값을 채워야 할지 명확하게 정하여 생성 시점에 값을 채워준다.
    private CommentResponse(final String title, final String content, final String memberName, final String comment) {
        this.title = title;
        this.content = content;
        this.memberName = memberName;
        this.comment = comment;
    }

    public static CommentResponse from(final Comment comment) {
        return CommentResponse.builder()
                .memberName(comment.getMember().getName())
                .title(comment.getPost().getTitle())
                .content(comment.getPost().getContent())
                .comment(comment.getComment())
                .build(); // builder 선언을 하였기에 사용 가능
    }
}
