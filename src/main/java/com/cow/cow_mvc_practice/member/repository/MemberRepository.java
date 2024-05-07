package com.cow.cow_mvc_practice.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cow.cow_mvc_practice.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	//
	// void save(Member member);
	//
	// Member findById(Long memberId);
}
