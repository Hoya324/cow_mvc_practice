package com.cow.cow_mvc_practice.member.controller.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.cow.cow_mvc_practice.member.entity.Member;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Schema(title = "Member Response : 회원 결과 DTO")
public class MemberResponse {
	@Schema(description = "회원 ID")
	private final Long id;

	@Schema(description = "이름")
	private final String name;

	@Schema(description = "프로필 이미지 주소")
	private final String profileImage;

	@Schema(description = "작성한 게시글 제목")
	private final List<String> posts;

	@Builder
	private MemberResponse(final Long id, final String name, final String profileImage, final List<String> posts) {
		this.id = id;
		this.name = name;
		this.profileImage = profileImage;
		this.posts = posts;
	}

	public static MemberResponse from(final Member member) {
		List<String> posts = new ArrayList<>();
		member.getPosts().forEach((p) -> posts.add(p.getTitle()));
		return MemberResponse.builder()
			.id(member.getId())
			.name(member.getName())
			.profileImage(member.getProfileImage())
			.posts(posts)
			.build();
	}
}
