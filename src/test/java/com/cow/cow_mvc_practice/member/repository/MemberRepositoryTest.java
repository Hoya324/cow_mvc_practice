package com.cow.cow_mvc_practice.member.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cow.cow_mvc_practice.member.entity.Member;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {
	@Autowired
	MemberJPARepository memberRepository;

	@Test
	@DisplayName("회원 저장하기")
	void saveMember() {
		Member savedMember = memberRepository.save(Member.from("Test Member"));
		Assertions.assertThat(savedMember.getName()).isEqualTo("Test Member");
		Assertions.assertThat(savedMember.getProfileImage())
			.isEqualTo("https://mycowpracticebucket.s3.ap-northeast-2.amazonaws.com/anonymous.png");
		Assertions.assertThat(savedMember.getPosts().size()).isEqualTo(0);
	}

	@Test
	@DisplayName("회원 불러오기")
	void getMember() {
		Member savedMember = memberRepository.save(Member.from("Test Member"));

		Member findMember = memberRepository.findById(savedMember.getId()).orElseThrow();
		Assertions.assertThat(savedMember).isEqualTo(findMember);
	}

	@Test
	@DisplayName("모든 회원 불러오기")
	void getAllMembers() {
		Member member1 = Member.from("Test Member 1");
		memberRepository.save(member1);
		Member member2 = Member.from("Test Member 2");
		memberRepository.save(member2);
		Member member3 = Member.from("Test Member 3");
		memberRepository.save(member3);

		memberRepository.findAll();
		List<Member> findMembers = memberRepository.findAll();

		Assertions.assertThat(findMembers.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("회원 삭제하기")
	void deleteMember() {
		Member member = Member.from("Test Member");
		Member savedMember = memberRepository.save(member);

		boolean isExistBefore = memberRepository.existsById(savedMember.getId());
		memberRepository.deleteById(savedMember.getId());
		boolean isExistAfter = memberRepository.existsById(savedMember.getId());

		Assertions.assertThat(isExistBefore).isEqualTo(true);
		Assertions.assertThat(isExistAfter).isEqualTo(false);
	}

	@Test
	@DisplayName("회원 수정하기")
	void updateMember() {
		Member member = Member.from("Test Member");
		Member savedMember = memberRepository.save(member);

		savedMember.updateMemberName("Update Member");
		savedMember.updateProfileImage("Update_Image_Link");

		Member findMember = memberRepository.findById(savedMember.getId()).orElseThrow();
		Assertions.assertThat(findMember.getName()).isEqualTo("Update Member");
		Assertions.assertThat(findMember.getProfileImage()).isEqualTo("Update_Image_Link");
	}
}
