package com.cow.cow_mvc_practice.member.entity;

import java.util.ArrayList;
import java.util.List;

import com.cow.cow_mvc_practice.comment.entity.Comment;
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;
	private String name;
	private String profileImage; // URL

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private final List<Post> posts = new ArrayList<>();

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private final List<Comment> comments = new ArrayList<>();

	@Builder
	private Member(final Long id, final String name) {
		this.id = id;
		this.name = name;
		this.profileImage = "https://mycowpracticebucket.s3.ap-northeast-2.amazonaws.com/anonymous.png";
	}

	public static Member from(String name) {
		return Member.builder()
			.name(name)
			.build();
	}

	public void updateMemberName(String name) {
		this.name = name;
	}

	public void updateProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
}
