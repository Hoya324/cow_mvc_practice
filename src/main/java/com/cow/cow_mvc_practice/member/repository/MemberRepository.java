package com.cow.cow_mvc_practice.member.repository;

import java.util.Optional;

import com.cow.cow_mvc_practice.member.entity.Member;

public interface MemberRepository {

	void save(Member member);

	Optional<Member> findById(Long memberId);
}
