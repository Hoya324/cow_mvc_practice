package com.cow.cow_mvc_practice.post.entity;

import com.cow.cow_mvc_practice.member.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
	private LocalDateTime createdAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@Builder
	private Post(final String title, final String content, final Member member,final LocalDateTime createdAt) {
		this.title = title;
		this.content = content;
		this.member = member;
		this.createdAt = createdAt;
	}

	public static Post of(final String title, final String content, final Member member,final LocalDateTime createdAt) {
		return Post.builder()
			.title(title)
			.content(content)
			.member(member)
			.createdAt(LocalDateTime.now())
			.build();
	}

	public static Post from(String title) {
		return Post.builder()
            .title(title)
            .build();
	}
}