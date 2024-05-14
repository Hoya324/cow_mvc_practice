package com.cow.cow_mvc_practice.comment.entity;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.*;


@Getter // Class 내 모든 필드의 Getter method를 자동 생성한다.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자를 통해서 값 변경 목적으로 접근하는 메시지들 차단
@Entity // 실제 DB의 테이블과 매칭될 Class임을 명시
public class Comment {

    @Id // 해당 테이블의 PK 필드를 나타낸다.
    @Column(name = "comment_id") //테이블의 컬럼을 나타냄 //굳이 선언하지 않더라도 해당 Class의 필드는 모두 컬럼이 됨
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY) // 내 테이블이 M : 상대 테이블이 1 // 연관관계의 데이터를 어떻게 가져올 것인가 == fetch(패치) //  FetchType.Lazy -> 관계 테이블 데이터 말고 내 테이블 데이터만 조회하겠다.
    @JoinColumn(name = "member_id") //Entity 연관관계를 연결하기 위한 Column을 지정
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY) // 내 테이블이 M : 상대 테이블이 1 // 연관관계의 데이터를 어떻게 가져올 것인가 == fetch(패치) //  FetchType.Lazy -> 관계 테이블 데이터 말고 내 테이블 데이터만 조회하겠다.
    @JoinColumn(name = "post_id") //Entity 연관관계를 연결하기 위한 Column을 지정
    private Post post;

    @Builder // 어느 필드에 어떤 값을 채워야 할지 명확하게 정하여 생성 시점에 값을 채워준다.
    private Comment(final Member member, final Post post, final String comment) {
        this.comment = comment;
        this.member = member;
        this.post = post;
    }

    public static Comment from(final Member member, final Post post, final String comment) {
        return Comment.builder()
                .comment(comment)
                .member(member)
                .post(post)
                .build();
    }
}
