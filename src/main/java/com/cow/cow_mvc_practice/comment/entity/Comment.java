package com.cow.cow_mvc_practice.comment.entity;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import com.cow.cow_mvc_practice.utill.TimestampedEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@AttributeOverride(name = "id", column = @Column(name = "comment_id"))
public class Comment extends TimestampedEntity {

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    private Comment(final String content, final Post post, final Member member) {
        this.content = content;
        this.post = post;
        this.member = member;
    }

    public void addMember(Member member) {
        this.member = member;
    }

    public void addPost(Post post) {
        this.post = post;
        post.getComments().add(this);
    }
}