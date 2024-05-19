package com.cow.cow_mvc_practice.comment.dto.request;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Getter;

@Getter
public class CreateCommentRequest {

    private Long id;
    private String content;

    public Comment toEntity(Member member, Post post) {
        return Comment.from(this.content, member, post);
    }
}
