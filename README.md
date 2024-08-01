# 경매서비스 개발

## 설명

개인적으로 진행한 사이드 프로젝트입니다. 백엔드와 프론트엔드를 모두 포함하지만 배포목적이 아닌 학습(+재미)용도의 프로젝트이기 때문에 UI보다는 백엔드 기능(트래픽 처리, 데이터 정합성, 테스트코드, API 문서화)을 중점으로 진행하였습니다.

다음은 프로젝트 진행에 대한 글입니다.

1. [기능정의](https://youngwonseo.tistory.com/6)
1. [시스템 아키텍처와 프로젝트 세팅](https://youngwonseo.tistory.com/7)
1. [데이터베이스 설계](https://youngwonseo.tistory.com/8)
1. [소셜 로그인 구현 (JWT)](https://youngwonseo.tistory.com/9)
1. [상품목록 (Querydsl, N+1)](https://youngwonseo.tistory.com/10)
1. [경매기능(Websocket, Redis, RabbitMQ)](https://youngwonseo.tistory.com/11)
1. [테스팅과 문서화 (JUnit5, Spring Docs Rest)](https://youngwonseo.tistory.com/12)
1. [프론트엔드 상태관리](https://youngwonseo.tistory.com/13)
1. [결과 UI](https://youngwonseo.tistory.com/14)
1. [무중단 배포와 로드 벨런싱](https://youngwonseo.tistory.com/15)
1. [CI/CD](https://youngwonseo.tistory.com/16)
1. [마무리](https://youngwonseo.tistory.com/17)

## 기술스택

- 백엔드
  - Java
  - Spring boot
  - Spring Data JPA
  - Spring Data Redis
  - Spring Validation
  - Spring Websocket
  - Spring Security
  - Spring Rest Docs
  - Lombok
  - Querydsl
  - Java JWT
- 프론트엔드
  - Typescript
  - ReactJS
  - Redux-Saga
  - Typesafe Action
  - Axios
  - Socket.io
  - Sementic UI
  - Echart
- 데이터베이스
  - MySql
- 저장소
  - AWS S3
- Etc
  - Docker
  - Nginx

## 시스템구성

![](./docs/system.png)

## 데이터베이스

![](./docs/database.png)

## 경매처리

![](./docs/traffic-handling.png)

## CI/CD

![](./docs/ci-cd.png)

## UI

### 로그인

![](./docs/screenshot-login.png)

### 상품목록

![](./docs/screenshot-main.png)
