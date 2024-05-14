package com.cow.cow_mvc_practice.comment.controller.service;

import com.cow.cow_mvc_practice.comment.controller.dto.response.CommentResponse;
import com.cow.cow_mvc_practice.comment.controller.repository.CommentJPARepository;
import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.member.entity.Member;
import com.cow.cow_mvc_practice.member.repository.MemberJPARepository;
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
public class CommentServiceImpl implements CommentService {

    private final CommentJPARepository commentRepository;
    private final MemberJPARepository memberRepository;
    private final PostJPARepository postRepository;

    @Override
    public CommentResponse join(Long memberId, Long postId, String commentText) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new EntityNotFoundException("[Error] 사용자를 찾을 수 없습니다."));
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("[Error] 게시물을 찾을 수 없습니다."));
        Comment comment = Comment.from(member, post, commentText);
        commentRepository.save(comment);
        post.increaseCommentNumber();
        postRepository.save(post);
        return CommentResponse.from(comment);
    }

    @Override
    public CommentResponse findOne(Long commentId) {
        return null;
    }
    @Override
    public List<CommentResponse> findAll() {
        return null;
    }
    @Override
    public void deleteComment(Long memberId) {

    }
}
