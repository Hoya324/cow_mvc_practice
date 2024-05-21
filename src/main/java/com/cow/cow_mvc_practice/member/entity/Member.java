package com.cow.cow_mvc_practice.member.entity;

import java.util.ArrayList;
import java.util.List;

import com.cow.cow_mvc_practice.post.entity.Post;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
	// id와 	name은 Member table의 칼, id는 PK이다
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 DB에게 위임
	@Column(name = "member_id") // 칼럼명 지정
	private Long id;

	private String name;

	// 예로 들면 한명의 손님이 여러 개의 계좌를 가질 수 있다, 계좌 입장에서는 @ManyToOne
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL) // 양방향 매핑일 때 // 다른 table의 member컬럼과 매핑?
	private final List<Post> posts = new ArrayList<>();

	@Builder
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
