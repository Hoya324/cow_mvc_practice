# COW MVC PRACTICE 초기 코드

## docker 실행 방법

1. build 후 터미널에 `docker compose up` 을 입력한다.
    - 또는 application을 실행시킨다.

2. 종료 시에는 `docker compose down` 을 입력한다.

## 구현 미션

- 이번주 미션은 저번 세션에서 했던 Spring MVC 실습 + JPA를 활용해 추가적인 CRUD를 하는 미션으로 하겠습니다.
- id의 생성 방식은 MySQL의 Auto Increment로 하고 JPA가 아닌 Spring Data JPA를 사용하는 것으로 제한하겠습니다.
- 엔티티를 반환하는 것이 아닌, DTO를 사용해서 필요한 값들만 반환해주도록 합니다.
    - builder 패턴을 적용해보시면 좋습니다!
    - [Builder 패턴 참고자료](https://inpa.tistory.com/entry/GOF-%F0%9F%92%A0-%EB%B9%8C%EB%8D%94Builder-%ED%8C%A8%ED%84%B4-%EB%81%9D%ED%8C%90%EC%99%95-%EC%A0%95%EB%A6%AC)

> 필요한 api를 직접 작성하는 능력을 키우고자, 큰 가이드 라인을 드리지 않았습니다.

### 요구사항
1. 사용자는 사용자의 정보를 수정할 수 있습니다. 이때 변경감지를 사용해 수정해주세요. 실제 Member의 id값은 로그인을 통해 토큰의 값을 해석해 가져오거나, 세션 id를 통해 가져오나 이번 미션에서는 members/1 과 같이 Path Variable을 사용해주세요.
2. Comment Entity를 생성해주세요. Comment Entity는 게시글과 1 : N, Member와 1 : N의 관계를 가지고 있습니다.
3. 사용자는 특정 게시글을 조회할 수 있습니다. 이때 posts/1 와 같이 Path Variable을 통해 조회해주세요.

   이때 게시글 제목, 게시글 내용, 게시글 작성자, 작성일시, 댓글 내용을 반환합니다.


![스크린샷 2023-09-08 오후 8.08.18.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/09718eb2-b1ef-4f91-ad51-f8ee77d6a328/2fe527bb-6cf3-4f85-a2a1-8f0ffa8f25ed/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-09-08_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_8.08.18.png)

1. 사용자는 게시글을 작성할 수 있습니다. Post를 생성하기 위한 정보는 body를 사용해주세요.

   사용자는 제목과 내용을 입력해 게시글을 생성합니다. members/1와 같이 Path Variable을 사용해주세요.

   ![스크린샷 2023-09-08 오후 8.26.37.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/09718eb2-b1ef-4f91-ad51-f8ee77d6a328/fc5a4986-a702-4471-9cdf-0439f36aaa2e/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-09-08_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_8.26.37.png)

2. 사용자는 댓글을 작성할 수 있습니다. 이때 members/2/posts/1 와 같은 Path Variable를 사용하고, comment의 내용은 body를 통해 전달하는 것으로 합니다. 이때 게시글에 댓글이 작성된다면 해당 게시글의 댓글 개수를 추가하는 메서드를 작성해주세요.
3. 사용자는 모든 게시글들을 조회할 수 있습니다. 게시글의 id, 게시글의 제목, 작성자의 이름, 게시글의 댓글 개수를 리스트로 반환합니다.

   ![스크린샷 2023-09-08 오후 7.56.42.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/09718eb2-b1ef-4f91-ad51-f8ee77d6a328/b0b4136d-e516-4064-a2cd-ed60b669f81c/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-09-08_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_7.56.42.png)

4. 사용자는 게시글을 삭제할 수 있습니다. 이때 cascade 옵션을 사용해 해당 게시글의 댓글도 같이 삭제합니다. cascade 옵션에 대해 학습하기 위해서 다음과 같은 링크를 참고해주세요. 또한 cascade 옵션이 있을 경우와 cascade 있을 경우 쿼리를 비교해서 캡쳐해주세요.

   [https://velog.io/@max9106/JPA엔티티-상태-Cascade](https://velog.io/@max9106/JPA%EC%97%94%ED%8B%B0%ED%8B%B0-%EC%83%81%ED%83%9C-Cascade)