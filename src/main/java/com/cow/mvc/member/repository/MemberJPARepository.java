package com.cow.mvc.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cow.mvc.member.entity.Member;

public interface MemberJPARepository extends JpaRepository<Member, Long> {
}
