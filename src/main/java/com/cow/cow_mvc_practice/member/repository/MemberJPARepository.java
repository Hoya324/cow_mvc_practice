package com.cow.cow_mvc_practice.member.repository;

import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cow.cow_mvc_practice.member.entity.Member;

import java.util.Optional;

public interface MemberJPARepository extends JpaRepository<Member, Long> {
}
