package com.cow.cow_mvc_practice.member.controller.dto.response;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.member.entity.Member;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MemberCommentsResponse {

    private final String memberName;
    private final List<String> commentContents;

    @Builder
    private MemberCommentsResponse(String memberName, List<String> commentList) {
        this.memberName = memberName;
        this.commentContents = commentList;
    }

    public static MemberCommentsResponse from(final Member member, List<String> commentContents) {
        return MemberCommentsResponse.builder()
                .memberName(member.getName())
                .commentList(commentContents)
                .build();
    }
}
