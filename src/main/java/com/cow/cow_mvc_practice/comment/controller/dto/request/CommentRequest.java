package com.cow.cow_mvc_practice.comment.controller.dto.request;

import java.sql.ConnectionBuilder;
import java.util.List;
import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import com.cow.cow_mvc_practice.member.entity.Member;
import lombok.Getter;

@Getter
public class CommentRequest {

    private Member member;
    private String title;
    private String comment;


    public Comment toEntity(Member member) {
        return Comment.builder()
                .member(member)
                .title(title)
                .comment(comment)
                .build();
    }
}
