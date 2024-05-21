package com.cow.cow_mvc_practice.member.entity;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.post.entity.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity // 실제 DB의 테이블과 매칭될 Class임을 명시
@Getter // Class 내 모든 필드의 Getter method를 자동 생성한다.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본생성자를 자동으로 추가 // 기본생성자의 접근 권한을 protected로 제한
public class Member {

	@Id // 해당 테이블의 PK 필드를 나타낸다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타낸다. // GenerationType.IDENTITY => 기본 키 생성을 데이터베이스에 위임한다.
	@Column(name = "member_id") //테이블의 컬럼을 나타냄 //굳이 선언하지 않더라도 해당 Class의 필드는 모두 컬럼이 됨
	private Long id;

	@Setter
	private String name;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL) // 이 Table 1 : 관계 테이블 Many
	private final List<Post> posts = new ArrayList<>();

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL) // 이 Table 1 : 관계 테이블 Many
	private final List<Comment> comments = new ArrayList<>();

	@Builder // 어느 필드에 어떤 값을 채워야 할지 명확하게 정하여 생성 시점에 값을 채워준다.
	private Member(final Long id, final String name) {
		this.id = id;
		this.name = name;
	}

	public static Member from(String name) {
		return Member.builder()
			.name(name)
			.build();
	}

	public static Member of(Long id, String name) {
		return Member.builder()
			.id(id)
			.name(name)
			.build();
	}
}
