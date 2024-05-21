package com.cow.mvc.member.repository;

import java.util.List;
import java.util.Optional;

import com.cow.mvc.member.entity.Member;

public interface MemberRepository {

	void save(Member member);

	Optional<Member> findById(Long memberId);

	Optional<List<Member>> findAll();
}
