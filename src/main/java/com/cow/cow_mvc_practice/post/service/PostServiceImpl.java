package com.cow.cow_mvc_practice.post.service;

import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.repository.MemberJPARepository;
import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostAmountResponse;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostCommentsResponse;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;
import com.cow.cow_mvc_practice.post.entity.Post;
import com.cow.cow_mvc_practice.post.repository.PostJPARepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service // Service Class에서 쓰인다. // 비즈니스 로직을 수행하는 Class라는 것을 나타내는 용도이다.
@RequiredArgsConstructor ////final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성
@Transactional //method 내부에서 일어나는 데이터베이스 로직이 전부 성공하게되거나 데이터베이스 접근중 하나라도 실패하면 다시 롤백할 수 있게 해주는 Annotation
public class PostServiceImpl implements PostService {

    private final PostJPARepository postRepository;
    private final MemberJPARepository memberRepository;

    @Override
    public PostResponse create(String memberName, PostRequest postRequest) {
        Member member = memberRepository.findByName(memberName)
                .orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));

        Post post = postRequest.toEntity(member);

        postRepository.save(post);

        return PostResponse.from(post);
    }

    @Override
    public PostAmountResponse findOne(String postTitle) {
        Post post = postRepository.findByTitle(postTitle)
                .orElseThrow(() -> new EntityNotFoundException("[Error] 게시물을 찾을 수 없습니다."));

        int commentAmount = getCommentsAmount(post);
        return PostAmountResponse.from(post, commentAmount);
    }

    @Override
    public void deletePost(String title) {
        postRepository.deleteByTitle(title);
    }

    @Override
    public PostCommentsResponse getPostComments(String title) {
        Post post = postRepository.findByTitle(title)
                .orElseThrow(() -> new EntityNotFoundException("[Error] 게시물을 찾을 수 없습니다."));

        List<String> commentContents = post.getComments().stream()
                .map(Comment::getComment)  // 댓글 내용만 추출
                .toList();

        return PostCommentsResponse.from(post, commentContents);
    }

    private int getCommentsAmount(Post post) {
        List<String> commentContents = post.getComments().stream()
                .map(Comment::getComment)  // 댓글 내용만 추출
                .toList();

        return commentContents.size();
    }
}
