package com.cow.cow_mvc_practice.post.entity;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.member.entity.Member;

import com.cow.cow_mvc_practice.utils.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자를 통해서 값 변경 목적으로 접근하는 메시지들 차단
@Entity
public class Post extends BaseEntity {

	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();


	@Builder
	private Post( final Long id, final String title, final String content, final Member member, final List<Comment> comments, final LocalDateTime createdAt) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.member = member;
		this.comments = comments;
		super.createdAt = createdAt;
	}

	public static Post of(String title, String content, Member member) {
		return Post.builder()
				.title(title)
				.content(content)
				.member(member)
				.build();
	}

	public void addComment(Comment comment) {
		this.comments.add(comment);
	}


	public String getMemberName() {
		return this.member.getName();
	}
}
