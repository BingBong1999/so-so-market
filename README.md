# Project - SoSoMarket (회원 간 굿즈 거래 및 경매 시스템)
## 목차


## 🌑 프로젝트 정보

![image](https://github.com/BingBong1999/so-so-market/assets/142529694/8a8eca3d-cb74-405b-a5dc-767b901b70eb)
- **동덕여자대학교** 4학년 1학기 **소프트웨어 시스템 개발** 과목에서 수행한 프로젝트입니다.
- 총 4 명의 팀원으로 구성하여 한 학기동안 진행하였습니다.
- 해당 README.md 파일은 **요약된 정보**만 기재되어 있습니다. 더 많은 정보를 확인하시려면 아래 첨부된 **pdf 파일 및 mp3 파일 공유 링크를 확인해주시면** 감사하겠습니다.
 	- https://drive.google.com/file/d/1HcYkglrOLJpaS3OkbAWgJ1bHG3U5FI2q/view?usp=sharing **(pdf 파일 링크)**
  - https://drive.google.com/file/d/1nfy_289BUxztjc7DZzhDfx9vLQQt3c_J/view?usp=sharing **(pdf 발표 자료 구두 설명 및 프로젝트 시연 영상)**

## 🌒 개발 배경 및 목적

- 포켓몬빵의 띠부띠부씰과 같은 **중고물품**의 경우, 판매자와 구매자들은 **상품의 적정 가격**을 책정하는 데 많은 고민을 합니다.
- **소소마켓**은 구매자와 판매자들의 이러한 고민을 해결하기 위해, 단순히 **중고 상품을 판매**하는 것 외에도 **경매 기능을 도입**하였습니다.
- **판매자는 상품을 경매에 부치고**, **구매자들은 입찰에 참여**하여, 최종적으로 **가장 높은 가격을 제시한 사용자**가 **해당 상품을 낙찰**받게 됩니다.

## 🌓 Skill
- **Language**: java, HTML, CSS, Java Script, SQL
- **Database**: Oracle
- **Framework**: Spring, Bootstrap, MyBatis
- **Design Pattern**: MVC Pattern, Facade Pattern

## 🌔 주요 기능

### 일반상품/경매상품
- 사용자는 일반 상품 판매 게시글을 생성, 조회, 수정, 삭제할 수 있습니다.
- 사용자는 경매 상품 판매 게시글을 생성, 조회, 수정, 삭제할 수 있습니다.
  - 경매 상품의 경우, 판매자가 게시글을 삭제하면 판매자의 신용도가 하락합니다.
    - 경매 상품의 경우 판매자의 악용을 막기 위해 수정이 불가하며 삭제만 가능합니다.
  - 경매 상품의 경우, 판매자가 설정한 경매 마감 기한이 지나면 최고가로 입찰된 가격이 자동으로 낙찰됩니다.

### 입찰
- 경매 상품 판매 게시글에 구매자가 입찰하려면, 현재 입찰가보다 높은 값만 제시할 수 있습니다.

### 사용자
- 사용자는 회원가입을 통해 계정을 생성할 수 있습니다.
- 사용자는 마이페이지에서 개인 정보를 조회하거나 수정하고, 계정 탈퇴를 진행할 수 있습니다.
    - 회원 탈퇴를 진행할 경우, 실수로 계정을 삭제하는 것을 방지하기 위해 비밀번호를 재입력해야 작업을 진행할 수 있습니다.
- 사용자는 아이디와 비밀번호를 입력하여 로그인하고, 버튼을 클릭하여 로그아웃할 수 있습니다.

### 주문
- 사용자가 특정 상품을 구매하면 주문서가 생성됩니다.
- 상품의 구매자와 판매자 모두 주문서를 조회할 수 있습니다.

### 위시리스트
- 사용자는 위시리스트에 원하는 상품을 추가하고, 조회하고, 삭제할 수 있습니다.
- 위시리스트에 추가된 상품은 종류별로 분류하여 볼 수 있습니다.

### 기타
- 사용자는 카테고리와 키워드로 상품을 검색할 수 있습니다.

## 🌕 시스템 설계 과정

### 팀 구성 및 추진 일정 계획
- 프로젝트의 주제를 선정하고, 팀원의 역할을 분담하였습니다.
- 매 주 **Google Meet**를 사용하여 회의하고, 회의 시간을 잊지 않도록 회의 전에 서로 리마인드하기로 하였습니다.
- 매주 회의 시간에 각 팀원의 담당 업무를 확인하고, 진행 상황을 공유할 수 있도록 **Notion**을 사용하였습니다.
- 프로젝트 진행은 다음과 같은 단계로 기획하였습니다.
    - **기획**: 팀 구성, 요구사항 분석
    - **설계**: UI/VIEW 설계, 비즈니스 로직 설계, DB Schema 설계, Model 설계, Controller 클래스 설계
    - **개발**: DB 구축, VIEW 구현, Model 구현, Controller 클래스 구현, Prototype 완성
    - **테스트**: 시나리오 작성, 최종 테스트
    - **완성**: 최종 보고서 작성, 결과물 제출
 
 ### 요구사항 분석
 - **시장 조사 및 사례 분석**
    - 다양한 중고 경매 서비스인 ‘째깍’, ‘코베이 옥션’, ‘재팬 스타일’, ‘이베이’, ‘텀블벅’ 등을 참고하여 요구사항을 분석하였습니다.
    - 각 서비스의 차별화된 장점을 파악하고, 이를 문서로 작성하여 프로젝트에 반영할 수 있는 인사이트를 도출하였습니다.
- **요구사항 명세 작성**
    - 서비스의 요구사항을 정의하고, 이를 유형과 우선순위에 따라 체계적으로 작성하였습니다.
    - **요구사항의 유형**
        - Functional (기능적 요구사항)
        - Products (제품 요구사항)
        - User Interface (사용자 인터페이스 요구사항)
        - Orders (주문 요구사항)
        - Nonfunctional (비기능적 요구사항)
        - Security (보안 요구사항)
        - Registration (사용자 등록 요구사항)
    - **요구사항의 우선순위**
        - Must-Have (필수 요구사항)
        - Could-Have  (선택 가능 요구사항)
        - Should-Have (권장 요구사항)
- **Use-case 명세 작성**
    - 사용자 요청의 단위로 Use-case를 세분화하여 사용자와 시스템 간의 상호작용을 구체적으로 정의하였습니다.
    - 각 세부 기능 간의 관계를 시각적으로 표시한 Use-case Diagram을 작성하였습니다.
    - 사용자의 종류에 따라 수행하는 역할을 설명하는 Actor-Semantics 문서를 작성하였습니다.
    - 각 Use-case에 대한 자세한 설명을 기록한 Use-case Brief Semantics 테이블을 작성하였습니다. 이 테이블에는 Use-case의 ‘**Actor**’, ‘**Preconditions**’, ‘**Flow of events**’, ‘**Postconditions**’를 포함하여 상세하게 기술하였습니다.

## 🛴 요구사항 분석

![image](https://github.com/BingBong1999/so-so-market/assets/142529694/c838a05e-afcc-4276-881e-2f1174a02e97)

## 🧭 use-case model

![image](https://github.com/BingBong1999/so-so-market/assets/142529694/6e30bd2d-8cda-4afa-b25f-cc2d68654bc3)
![image](https://github.com/BingBong1999/so-so-market/assets/142529694/2476b4e5-8dae-4783-9499-072b65d2d6d3)
![image](https://github.com/BingBong1999/so-so-market/assets/142529694/6e9d47d3-ef47-4379-a8d2-1836a4bc3cae)

## 🌊 시스템 구성도

![image](https://github.com/BingBong1999/so-so-market/assets/142529694/40dffbd6-904f-4e22-836c-a59552608046)
![image](https://github.com/BingBong1999/so-so-market/assets/142529694/8c0d25a5-4b8d-4937-812f-fe089474d27e)


## 🚝 UI 설계

![image](https://github.com/BingBong1999/so-so-market/assets/142529694/b1aeb27d-345d-4193-89ca-93c5765216f5)

- 해당 UI는 추후 와이어프레임으로 재설계되었습니다.
- (카카오 오븐) 다음 링크를 누르시면 자세한 UI 설계 내용을 확인할 수 있습니다. https://ovenapp.io/view/eCW3HIbZ8KcDWxVHeLJ5soTCYyFbJgrT#7PTcT

## 🚔 Domain

![image](https://github.com/BingBong1999/so-so-market/assets/142529694/b46ac8c2-cb79-45e7-a43b-5cd0019d92fe)

## 🐤 DB

![image](https://github.com/BingBong1999/so-so-market/assets/142529694/0b9ab447-af75-4537-ba82-40ce26456ef8)

## 🎈 Request Mapping

![image](https://github.com/BingBong1999/so-so-market/assets/142529694/3ae913d4-078c-4a09-a5be-8cd239a4d4b1)

- (구글 스프레드 시트) 다음 링크를 누르시면 자세한 Request Mapping 내용을 확인할 수 있습니다. https://docs.google.com/spreadsheets/d/1fe1fcmk3U99QAK8U8Nj6eXWwVl_a3t45R8zvjZ1bkjA/edit#gid=0

## 🎯 비즈니스 로직이 사용된 프로그램 기능 이미지 파일

![image](https://github.com/BingBong1999/so-so-market/assets/142529694/ac4b4148-e968-4b03-a867-0307c8cfbf26)
![image](https://github.com/BingBong1999/so-so-market/assets/142529694/63fc1c6d-ce44-422f-9a2f-df8bb1c030d5)
![image](https://github.com/BingBong1999/so-so-market/assets/142529694/2b99e457-94c3-4928-a527-1c988cecb3bf)
![image](https://github.com/BingBong1999/so-so-market/assets/142529694/a568828e-7430-46a3-8c63-aad55a347372)
![image](https://github.com/BingBong1999/so-so-market/assets/142529694/d8f49243-da56-44f0-babb-37e80ebd621e)

- 더 자세한 내용은 README.md 파일 상단에 첨부한 pdf 공유 링크를 확인해주시면 감사하겠습니다.
