package com.cow.cow_mvc_practice.post.controller;

import com.cow.cow_mvc_practice.post.controller.dto.request.PostRequest;
import com.cow.cow_mvc_practice.post.controller.dto.response.PostResponse;
import com.cow.cow_mvc_practice.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 @RestController와 @Controller의 차이점
 -> Controller : API와 View를 동시에 사용하는 경우에 사용 // view return이 주 목적 // @ResponseBody로 객체 반환
 -> RestController : View가 필요 없는 API 지원만 하는 서비스에 사용
 **/

@RestController // Spring에서 Controller 중 View로 응답하지 않는, Controller를 의미 // method의 반환 결과를 JSON 형태로 반환
@RequestMapping("/posts") // 요청 URL을 어떤 method가 처리할지 mapping해주는 Annotation
@RequiredArgsConstructor //final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성
public class PostController {

    private final PostService postService;
    @PostMapping("/new-post-member{memberId}") // RequestMapping(Method=RequestMethod.Post)와 같다.
    public PostResponse create(@PathVariable final Long memberId, @RequestBody final PostRequest postRequest) { // 요청에서 넘어온 body 값들을 자바 타입으로 파싱
        return postService.join(memberId, postRequest.getTitle(), postRequest.getContent());
    }
    @GetMapping("/{postId}") // // RequestMapping(Method=RequestMethod.Get)와 같다.
    public PostResponse findPost(@PathVariable Long postId) {
        return postService.findOne(postId);
    }

}

