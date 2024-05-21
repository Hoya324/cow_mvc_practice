package com.cow.cow_mvc_practice.member.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cow.cow_mvc_practice.member.entity.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	/**
	 * 원래라면 HashMap이 아닌, concurrentHashMap이 적합함. HashMap은 멀티 쓰레드 환경에서 사용할 수 없기 때문.(동시성 이슈)
	 */
	private static final Map<Long, Member> store = new HashMap<>();

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
