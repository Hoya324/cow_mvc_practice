package com.cow.cow_mvc_practice.comment.controller.dto.request;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentRequest {

    String memberName;
    String postTitle;
    String comment;

    @Builder
    public CommentRequest(String memberName, String postTitle, String comment) {
        this.memberName = memberName;
        this.postTitle = postTitle;
        this.comment = comment;
    }

    public Comment toEntity(Member member, Post post) {
        return Comment.builder()
                .member(member)
                .post(post)
                .comment(comment)
                .build();
    }
}
