package com.cow.cow_mvc_practice.comment.dto.request;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;
import lombok.Getter;

@Getter
public class CommentRequest {
	 Long id;
	 String content;

	 public Comment toEntity(Member member, Post post) {
		 return Comment.builder()
				 .content(content)
				 .post(post)
				 .member(member)
				 .build();
	 }
}
