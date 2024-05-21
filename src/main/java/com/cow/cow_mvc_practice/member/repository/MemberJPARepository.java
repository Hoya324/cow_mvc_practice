package com.cow.cow_mvc_practice.member.repository;

import com.cow.cow_mvc_practice.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJPARepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String name);

    void deleteByName(String memberName);
}
