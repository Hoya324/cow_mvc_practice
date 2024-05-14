package com.cow.cow_mvc_practice.comment.controller.dto;

import com.cow.cow_mvc_practice.comment.controller.dto.request.CommentRequest;
import com.cow.cow_mvc_practice.comment.controller.dto.response.CommentResponse;
import com.cow.cow_mvc_practice.comment.controller.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController // Spring에서 Controller 중 View로 응답하지 않는, Controller를 의미 // method의 반환 결과를 JSON 형태로 반환
@RequestMapping("/comment") // 요청 URL을 어떤 method가 처리할지 mapping해주는 Annotation
@RequiredArgsConstructor //final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/members/{memberId}/posts/{postId}") // RequestMapping(Method=RequestMethod.Post)와 같다.
    public CommentResponse create(@PathVariable Long memberId, @PathVariable Long postId, @RequestBody CommentRequest commentRequest) { // 요청에서 넘어온 body 값들을 자바 타입으로 파싱
        return commentService.join(memberId, postId, commentRequest.getComment());
    }
}
