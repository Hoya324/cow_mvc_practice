package com.cow.cow_mvc_practice.post.entity;

import com.cow.cow_mvc_practice.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;

@Getter // Class 내 모든 필드의 Getter method를 자동 생성한다.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자를 통해서 값 변경 목적으로 접근하는 메시지들 차단
@Entity // 실제 DB의 테이블과 매칭될 Class임을 명시
public class Post {
	@Id // 해당 테이블의 PK 필드를 나타낸다.
	@Column(name = "post_id") //테이블의 컬럼을 나타냄 //굳이 선언하지 않더라도 해당 Class의 필드는 모두 컬럼이 됨
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String content;
	@CreationTimestamp
	@Column(name = "ins_date")
	private Time timeStamp;

	@ManyToOne(fetch = FetchType.LAZY) // 내 테이블이 M : 상대 테이블이 1 // 연관관계의 데이터를 어떻게 가져올 것인가 == fetch(패치) //  FetchType.Lazy -> 관계 테이블 데이터 말고 내 테이블 데이터만 조회하겠다.
	@JoinColumn(name = "member_id") //Entity 연관관계를 연결하기 위한 Column을 지정
	private Member member;

	private int commentNumber;

	@Builder // 어느 필드에 어떤 값을 채워야 할지 명확하게 정하여 생성 시점에 값을 채워준다.
	private Post(final String title, final String content, final Member member) {
		this.title = title;
		this.content = content;
		this.member = member;
		this.commentNumber = 0;
	}

	public void increaseCommentNumber() {
		commentNumber++;
	}

	public static Post from(final String title, final String content, final Member member) {
		return Post.builder()
			.title(title)
			.content(content)
			.member(member)
			.build();
	}
}