package com.cow.cow_mvc_practice.member.controller;

import java.util.List;

import com.cow.cow_mvc_practice.member.controller.dto.request.UpdateMemberRequest;
import org.springframework.web.bind.annotation.*;

import com.cow.cow_mvc_practice.member.controller.dto.request.MemberRequest;
import com.cow.cow_mvc_practice.member.controller.dto.response.MemberResponse;
import com.cow.cow_mvc_practice.member.service.MemberService;

import lombok.RequiredArgsConstructor;

/**
 @RestController와 @Controller의 차이점
 -> Controller : API와 View를 동시에 사용하는 경우에 사용 // view return이 주 목적 // @ResponseBody로 객체 반환
 -> RestController : View가 필요 없는 API 지원만 하는 서비스에 사용
 **/

@RestController // Spring에서 Controller 중 View로 응답하지 않는, Controller를 의미 // method의 반환 결과를 JSON 형태로 반환
@RequestMapping("/member") // 요청 URL을 어떤 method가 처리할지 mapping해주는 Annotation
@RequiredArgsConstructor //final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성
public class MemberController {

	private final MemberService memberService;

	/* 기본 */
	// @PostMapping("/new")
	// public String create(@RequestBody final MemberRequest memberRequest) {
	// 	memberService.join(memberRequest);
	// 	return "회원저장 성공!";
	// }
	//
	// @GetMapping("/{memberId}")
	// public String findMember(@PathVariable final Long memberId) {
	// 	Member member = memberService.findOne(memberId);
	// 	return "member 아이디: " + member.getId() + ", member 이름: " + member.getName();
	// }
	//

	/* MemberResponse dto 적용 */
	@PostMapping("/new") // RequestMapping(Method=RequestMethod.Post)와 같다.
	public MemberResponse create(@RequestBody final MemberRequest memberRequest) { // 요청에서 넘어온 body 값들을 자바 타입으로 파싱
		return memberService.join(memberRequest.getName());
	}

	@GetMapping("/{memberId}") // // RequestMapping(Method=RequestMethod.Get)와 같다.
	public MemberResponse findMember(@PathVariable final Long memberId) { // 해당 URL에서 {특정값}을 변수로 받아 올 수 있다.
		return memberService.findOne(memberId);
	}

	@GetMapping() // RequestMapping(Method=RequestMethod.Get)와 같다.
	public MemberResponse findMemberQuery(@RequestParam final Long memberId) { // PathVariable과 비슷하다. // ?moviename=thepurge 와 같은 쿼리 파라미터를 파싱
		return memberService.findOne(memberId);
	}

	@GetMapping("/all")
	public List<MemberResponse> findMembers() {
		return memberService.findAll();
	}

	@PutMapping("/update")
	public MemberResponse updateMember(@RequestBody UpdateMemberRequest memberRequest) {
		return memberService.updateMemberInfo(memberRequest.getId(), memberRequest.getName());
	}
	@DeleteMapping("/delete")
	public void deleteMember(@RequestParam final Long memberId) {
		memberService.deleteMember(memberId);
	}

}

