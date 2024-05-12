package com.cow.cow_mvc_practice.member.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cow.cow_mvc_practice.member.entity.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();

	@Override
	public void save(Member member) {
		store.put(member.getId(), member);
	}

	@Override
	public Optional<Member> findById(Long memberId) {
		return Optional.ofNullable(store.get(memberId));
	}

	@Override
	public Optional<List<Member>> findAll() {
		return Optional.of((List<Member>)store.values());
	}
}
