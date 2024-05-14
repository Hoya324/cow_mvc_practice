package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.repository.MemberJPARepository;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;
import com.cow.cow_mvc_practice.post.entity.Post;
import com.cow.cow_mvc_practice.post.repository.PostJPARepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service // Service Class에서 쓰인다. // 비즈니스 로직을 수행하는 Class라는 것을 나타내는 용도이다.
@RequiredArgsConstructor ////final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성
@Transactional //method 내부에서 일어나는 데이터베이스 로직이 전부 성공하게되거나 데이터베이스 접근중 하나라도 실패하면 다시 롤백할 수 있게 해주는 Annotation
public class PostServiceImpl implements PostService {

    private final PostJPARepository postRepository;
    private final MemberJPARepository memberRepository;

    @Override
    public PostResponse join(Long memberId, String title, String content) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));
        Post post = Post.from(title, content, member);
        postRepository.save(post);
        return PostResponse.from(post);
    }

    @Override
    public PostResponse findOne(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("[Error] 게시물을 찾을 수 없습니다."));
        return PostResponse.from(post);
    }

    @Override
    public List<PostResponse> findAll(Long memberId) {
        return null;
    }

    @Override
    public void deletePost(Long memberId, String content) {

    }
}
