package com.cow.cow_mvc_practice.post.entity;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.member.entity.Member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자를 통해서 값 변경 목적으로 접근하는 메시지들 차단
@Entity
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @Builder
    private Post(final String title, final String content, final Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.created_at = LocalDateTime.now();
    }

    public static Post from(final String title, final String content, final Member member) {
        return Post.builder().title(title).content(content).member(member).build();
    }
}