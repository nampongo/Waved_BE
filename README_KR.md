# 🌊 챌린지의 파도를 넘어 취업으로, WAVED-BE
<img width="5760" height="4096" alt="image" src="https://github.com/user-attachments/assets/cc9d5dbd-0c08-4725-8c5a-e56ec00420cd" />
<img width="5760" height="4096" alt="image" src="https://github.com/user-attachments/assets/572f3015-00a4-4081-a55b-35dbef48c0b0" />
<img width="5760" height="4096" alt="image" src="https://github.com/user-attachments/assets/22f5fa2c-568f-4f32-ab1c-1ece1351dd50" />
<br>   

## 프로젝트 소개
- 개발자 맞춤형 챌린지 : 취업 준비가 외롭지 않도록 맞춤형 챌린지를 준비했어요.

- 동기부여 챌린지 : 참여할 챌린지에 예치금을 걸고, 챌린지를 완주할 동기부여를 얻으세요.

- 맞춤형 인증방식 : 각 챌린지별 최적의 인증 방식으로 효율적으로 달성률을 채워보세요.

- 인증내역 커뮤니티 : 매일 인증하고 같은 기수 개발자들과 답변을 공유하며, 함께 성장하세요.

## 서비스 링크
https://waved-likelion.site/ (sevice closed)

## 개발기간
- 개발 : 2024년 2월 26일 ~ 2024년 3월 22일
- 테스트 및 리팩토링 : 2024년 4일 1일 ~ 2024년 4월 26월

## Team
<img width="5760" height="4096" alt="image" src="https://github.com/user-attachments/assets/adb4e9bb-7524-4fcc-af50-7516e363aae5" />

## Tools
<div align=left> 
  <img width="80" height="38" alt="image" src="https://github.com/user-attachments/assets/1ae5f9ec-dabc-4a4a-8d4b-e1ace417c952" />
  <img height="38" src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <img height="38" src="https://img.shields.io/badge/OAuth-43853D?style=flat-square&logo=OAuth&logoColor=white"/>
  <img height="38" src="https://img.shields.io/badge/JWT-000000?style=flat-square&logo=JSONWebTokens&logoColor=white"/>
  <img height="38" src="https://img.shields.io/badge/lombok-C02E18?style=for-the-badge&logo=lombok&logoColor=white">
  <br>    

  <img src="https://img.shields.io/badge/SpringDataJPA-53B421?style=for-the-badge&logo=SpringDataJPA&logoColor=white">
  <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
  <br>
  <img src="https://img.shields.io/badge/redis-DC382D?style=for-the-badge&logo=redis&logoColor=white">
  <img src="https://img.shields.io/badge/azure-0078D4?style=for-the-badge&logo=microsoft-azure&logoColor=white">
  <img src="https://img.shields.io/badge/azure%20storage-0089D6?style=for-the-badge&logo=microsoft-azure&logoColor=white">
  <br>  

</div>

## API명세
- 포스트맨 : https://documenter.getpostman.com/view/34016201/2sA3JRXds2

## 테이블 (다이어그램)
<img width="1358" height="668" alt="image" src="https://github.com/user-attachments/assets/1eac1d10-7ba3-44c5-92e9-20a28544b645" />


## 패키지 구조
```

└── src
   ├── main
      ├── java
      │   └── com
      │      └── senity
      │          └── waved
      │             ├── base
      │	            │  ├── config
      │	            │  ├── exception
      │	            │  ├── jwt
      │	            │  ├── redis
      │	            │  └── security
      │	            ├── common
      │	            │	
      │	            │
      │	            └── domain
      │                  ├─── amdin
      │                       ├─── controller
      │                       └─── service
      │                  ├─── challenge
      │                       ├─── controller
      │                       ├─── entity
      │                       ├─── exception
      │                       ├─── repository
      │                       └─── service
      │                  ├─── challengeGroup
      │                       ├─── controller
      │                       ├─── dto
      │                            └─── response
      │                       ├─── entity
      │                       ├─── exception
      │                       ├─── repository
      │                       └─── service
      │                  ├─── event
      │                       ├─── controller
      │                       ├─── repository
      │                       └─── service
      │                  ├─── liked
      │                       ├─── controller
      │                       ├─── dto
      │                            └─── response
      │                       ├─── entity
      │                       ├─── exception
      │                       ├─── repository
      │                       └─── service	
      │                  ├─── member
      │                       ├─── controller
      │                       ├─── dto
      │                            ├─── request
      │                            └─── response
      │                       ├─── entity
      │                       ├─── exception
      │                       ├─── repository
      │                       └─── service
      │                  ├─── myChallenge
      │                       ├─── controller
      │                       ├─── dto
      │                            └─── response
      │                       ├─── entity
      │                       ├─── exception
      │                       ├─── repository
      │                       └─── service
      │                  ├─── notification
      │                       ├─── controller
      │                       ├─── dto
      │                            └─── response
      │                       ├─── entity
      │                       ├─── repository
      │                       └─── service
      │                  ├─── paymentRecord
      │                       ├─── controller
      │                       ├─── dto
      │                            ├─── request
      │                            └─── response
      │                       ├─── entity
      │                       ├─── exception
      │                       ├─── repository
      │                       └─── service
      │                  ├─── quiz
      │                       ├─── controller
      │                       ├─── dto
      │                            └─── response
      │                       ├─── entity
      │                       ├─── exception
      │                       ├─── repository
      │                       └─── service
      │                  ├─── review
      │                       ├─── controller
      │                       ├─── dto
      │                            └─── response
      │                       ├─── entity
      │                       ├─── exception
      │                       ├─── repository
      │                       └─── service
      │                  ├─── verification
      │                       ├─── controller
      │                       ├─── dto
      │                            ├─── request
      │                            └─── response
      │                       ├─── entity
      │                       ├─── exception
      │                       ├─── repository
      │                       └─── service
      │              
      │                           
      └── resource
              ├── application.yml
              └── application-secret.yml

```

# Feature
### A. 회원가입/로그인 '구글 OAuth2.0 JWT 토큰 방식'
`JWT 토큰 방식` : 스프링 시큐리티와 OAuth 2.0 로그인 연동을 JWT 토큰 기반으로 구현하였습니다.

`Redis` : 레디스를 사용해서 refresh Token을 저장하여 관리하였습니다.

`블랙리스트` : 로그아웃한 유저 토큰의 유효 시간동안 블랙 리스트 처리를 하여 보안을 강화하였습니다.

<br>  


### B. 다양한 챌린지 인증 방식 기능 구현
사진, 글, 링크, 깃헙 인증 방식 도입 및 인증 내역 조회
- `사진 인증` : 이미지 파일을 multipart 전송을 통해 업로드하면 Azure Blob Storage에 저장하도록 구현하였습니다.

- `깃헙 인증` : GithubApi를 사용해서 레포지토리의 당일 커밋 기록을 불러오도록 구현했습니다.

<br>

<img width="5760" height="4096" alt="image" src="https://github.com/user-attachments/assets/da1e6cb8-4af0-4269-89c6-367ab269733a" />
<img width="5760" height="4096" alt="image" src="https://github.com/user-attachments/assets/c58cba72-aa6b-4068-a245-800ee96891e2" />


### C. 좋아요 및 리뷰 기능
격리 수준으로 트랜잭션을 활용해서 DB 원자성을 보장하는 방식으로 좋아요 기능을 구현했습니다.  
→ 동시에 여러 개의 좋아요가 발생해도 엔티티 개수 조회하는 트랜잭션은 변경되지 않는 데이터 읽어서 높은 격리 수준을 가지게 됩니다.
<br><br>


### D. 데이터 생성 자동화
`불편함 발생` : 챌린지 기수제로 운영 시, 매번 수동으로 기수를 생성해야하는 불편함이 발생했습니다.

`자동화 처리` : 챌린지에 기수 관련 필드 추가 및 스케줄링을 통해 챌린지 기수 객체 생성 자동화 했습니다.

→ 이를 통해 운영 효율성과 데이터 정확성을 향상시켰습니다.
<br><br>


### E. 포트원 연동을 통한 결제 프로세스
`결제` : 포트원과 연동하여 결제 요청을 확인하고, 금액이 정확한지 체크하는 사후 검증 과정과 결제 취소 및 환급 과정의 전체 결제 프로세스를 구현했습니다.   
<br><br>


### F. SSE(Server-Sent-Events)를 이용한 실시간 알림 기능
`실시간 알림` : 스프링 서버 사이드 이벤트 SseEmitter로 구현하였고, 관리자 단에서 취소되는 인증에 대해 유저에게 확실하게 전달할 수 있도록 실시간 알림을 사용했습니다.  
<br>


### G. 예외 처리
`전역 예외 처리기 정의` : 전역 예외 처리기를 정의하고 예외 유형별로 처리 로직을 구현하였습니다.
- 각 유형에 대해 HTTP 상태 코드와 오류 메시지를 반환하도록 하여 협업을 위한 일관성 있는 예외 처리와 중복 코드를 줄일 수 있었습니다.
```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseDto> handleMemberNotFoundException(MemberNotFoundException e) {
        return ResponseDto.of(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(WrongGithubInfoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDto> handleWrongGithubInfoException(WrongGithubInfoException e) {
        return ResponseDto.of(HttpStatus.BAD_REQUEST, e.getMessage());
    }
    
    ...
    
}
```

# 🚀 ISSUE
### 1. 쿼리 최적화 시도 ‘부분 조회’
→ 불필요한 데이터 전송을 하고 있다고 판단해 성능 향상을 위한 부분 조회의 필요성을 느껴 다양한 테스트를 진행해보았습니다.

a. 성능 테스트 수행    
→ 여러 방법으로 부분 조회 실행 시 실행 시간 테스트 결과 dto 사용 부분 조회가 가장 적은 2~4배 정도의 시간이 소요됩니다. 데이터 조회 시 시간을 제외한 성능 개선을 위해 dto 사용 부분 조회로 결정하였습니다.

```
 
    Test1 - Elapsed time: 112 milliseconds // 기존 멤버 조회
    Test2 - Elapsed time: 673 milliseconds // QueryDSL 부분 조회
    Test3 - Elapsed time: 601 milliseconds // Projection 부분 조회
    Test4 - Elapsed time: 471 milliseconds // Dto 부분 조회

``` 

b. 데이터베이스 쿼리 분석

```
 
    Hibernate: 
        select
            m1_0.id,
            m1_0.auth_level,
            m1_0.birth_year,
            m1_0.create_date,
            m1_0.email,
            m1_0.gender,
            m1_0.github_id,
            m1_0.github_token,
            m1_0.has_info,
            m1_0.has_new_event,
            m1_0.job_title,
            m1_0.modified_date,
            m1_0.nickname 
        from
            member m1_0 
        where
            m1_0.id=?

``` 
```

    Hibernate: 
        /* SELECT
            new com.senity.waved.domain.challenge.service.NicknameDto(m.nickname) 
        FROM
            Member m 
        WHERE
            m.id =:id */ select
                m1_0.nickname 
            from
                member m1_0 
            where
                m1_0.id=?

``` 

c. 메모리 사용량 비교

```

    Test1 - Elapsed time: 103 milliseconds // 기존 멤버 조회
    Test1 - 메모리 사용량: 4527440
    
    Test2 - Elapsed time: 564 milliseconds // Dto 부분 조회
    Test2 - 메모리 사용량: 23068640

``` 

→ 효율 측정 결과 기존 방법인 전체 조회에서 메모리 사용량과 시간 소요에서 약 5배정도 추가로 들어 기존 방법으로 결정했습니다.

### 2. 객체 관계 최적화
→ 기수별로 운영되는 챌린지 서비스였기에 복잡한 객체 관계로 인해 불필요한 데이터가 조회되어 성능 저하가 발생했습니다.

a. `JPA 매핑 관계 재정의`
: 서비스에서 실제로 필요한 관계만 설정하고, 불필요한 매핑을 제거하였습니다. 또한 JPA의 자동 관계 설정 기능을 통해 얻을 수 없는 부분은 외래키 설정을 유지하며 서비스에 최적화 된 방법으로 객체 관계를 재정의 하였습니다.

b. `Entity와 DTO 변환으로 관심사 분리`
: 서비스의 자유도가 떨어지고, 유연성 저하되어 유지 보수 측면에서 엔티티에서 DTO 변환하는 구조가 필요하다고 판단했습니다. 이를 적용하여 관심사 책임 분리를 하여 코드 유연성을 높였습니다.

→ 이렇게 최적화를 진행하며 쿼리 호출 감소로 무한 루프를 방지하고, 실제 데이터 조회 속도가 2배 향상되었습니다.   
→ 마이 챌린지 페이지로 이동 시 3초 이상 걸렸는데 1초로 줄어들었습니다.  
