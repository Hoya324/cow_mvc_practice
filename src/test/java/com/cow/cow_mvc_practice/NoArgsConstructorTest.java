package com.cow.cow_mvc_practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.post.entity.Post;

import jakarta.persistence.EntityManager;

@SpringBootTest
@Testcontainers
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NoArgsConstructorTest {
	@Autowired
	private EntityManager em;

	@BeforeEach
	void makeEntity() {
		Member member = Member.from("경호는 진짜 바보");

		em.persist(member);

		Post post = Post.from("글 제목입니다.", "글 내용입니다.", member);
		em.persist(post);
	}

	@Test
	@Transactional
	void proxyTest() {

		Post post = em.find(Post.class, 1L);

		System.out.println("post의 ID 값은 : " + post.getId());
		System.out.println("user의 ID 값은 : " + post.getMember().getId());
	}

}
