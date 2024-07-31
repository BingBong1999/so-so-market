# Project - SoSoMarket (회원 간 굿즈 거래 및 경매 시스템)

## 🌞 목차

### **[1. 🌑 프로젝트 정보](#-프로젝트-정보)**

### **[2. 🌒 개발 배경 및 목적](#-개발-배경-및-목적)**

### **[3. 🌓 SKILL](#-SKILL)**

### **[4. 🌔 주요 기능](#-주요-기능)**

### **[5. 🌕 시스템 설계 과정](#-시스템-설계-과정)**

### **[6. 🌖 기능 구현](#-기능-구현)**

### **[7. 🌗 프로젝트 설정 및 실행 방법](#-프로젝트-설정-및-실행-방법)**

## 🌑 프로젝트 정보

![image](https://github.com/BingBong1999/so-so-market/assets/142529694/8a8eca3d-cb74-405b-a5dc-767b901b70eb)

- 동덕여자대학교 4학년 1학기 소프트웨어 시스템 개발 과목에서 수행한 프로젝트입니다.

- 총 4 명의 팀원으로 구성하여 한 학기동안 진행하였습니다.

- 해당 프로젝트에 대한 전반적인 정보는 본 README 파일에 기재되어 있지만,

  **요구사항 분석**, **Usecase Model**, **세부 기능 정의**, **시스템 구성도**, **UI 설계**, **도메인**, **DB 테이블**, **Request Mapping**, **구현 결과** 등이 포함된 **이미지 파일**은 

  아래의 첨부된 PDF 파일과 프로젝트 시연 영상 링크를 통해 확인해 주시기 바랍니다.

- 참고로, Commit 내역의 20190942 계정(필자의 학번)과 hello 계정은 모두 본인임을 밝힙니다. 또한, 본 README 파일 메인 이미지의 20190962 학번은 오타임을 알려드립니다.

- PDF 파일 및 프로젝트 시연 영상 링크:

 	- [so-so-market pdf 파일 링크](https://drive.google.com/file/d/1HcYkglrOLJpaS3OkbAWgJ1bHG3U5FI2q/view?usp=sharing)
    
  - [so-so-market 프로젝트 시연 영상 링크](https://drive.google.com/file/d/1nfy_289BUxztjc7DZzhDfx9vLQQt3c_J/view?usp=sharing)

## 🌒 개발 배경 및 목적

- 포켓몬빵의 띠부띠부씰과 같은 **중고물품**의 경우, 판매자와 구매자들은 **상품의 적정 가격**을 책정하는 데 많은 고민을 합니다.
  
- **소소마켓**은 구매자와 판매자들의 이러한 고민을 해결하기 위해, 단순히 **중고 상품을 판매**하는 것 외에도 **경매 기능을 도입**하였습니다.

- **판매자는 상품을 경매에 부치고**, **구매자들은 입찰에 참여**하여, 최종적으로 **가장 높은 가격을 제시한 사용자**가 **해당 상품을 낙찰**받게 됩니다.

## 🌓 SKILL

- **Language**: ```Java```, ```HTML```, ```CSS```, ```Java Script```, ```SQL```

- **Database**: ```Oracle```

- **Framework**: ```Spring```, ```Bootstrap```, ```MyBatis```

- **Design Pattern**: ```MVC Pattern```, ```Facade Pattern```

## 🌔 주요 기능

### 1. 일반상품/경매상품

- 사용자는 일반 상품 판매 게시글을 생성, 조회, 수정, 삭제할 수 있습니다.

- 사용자는 경매 상품 판매 게시글을 생성, 조회, 수정, 삭제할 수 있습니다.

  - 경매 상품의 경우, 판매자가 게시글을 삭제하면 판매자의 신용도가 하락합니다.

    - 경매 상품의 경우 판매자의 악용을 막기 위해 수정이 불가하며 삭제만 가능합니다.
      
  - 경매 상품의 경우, 판매자가 설정한 경매 마감 기한이 지나면 최고가로 입찰된 가격이 자동으로 낙찰됩니다.

### 2. 입찰

- 경매 상품 판매 게시글에 구매자가 입찰하려면, 현재 입찰가보다 높은 값만 제시할 수 있습니다.

### 3. 사용자

- 사용자는 회원가입을 통해 계정을 생성할 수 있습니다.

- 사용자는 마이페이지에서 개인 정보를 조회하거나 수정하고, 계정 탈퇴를 진행할 수 있습니다.

    - 회원 탈퇴를 진행할 경우, 실수로 계정을 삭제하는 것을 방지하기 위해 비밀번호를 재입력해야 작업을 진행할 수 있습니다.

- 사용자는 아이디와 비밀번호를 입력하여 로그인하고, 버튼을 클릭하여 로그아웃할 수 있습니다.

### 4. 주문

- 사용자가 특정 상품을 구매하면 주문서가 생성됩니다.

- 상품의 구매자와 판매자 모두 주문서를 조회할 수 있습니다.

### 5. 위시리스트

- 사용자는 위시리스트에 원하는 상품을 추가하고, 조회하고, 삭제할 수 있습니다.

- 위시리스트에 추가된 상품은 종류별로 분류하여 볼 수 있습니다.

### 6. 기타

- 사용자는 카테고리와 키워드로 상품을 검색할 수 있습니다.

## 🌕 시스템 설계 과정

### 1. 팀 구성 및 추진 일정 계획

- 프로젝트의 주제를 선정하고, 팀원의 역할을 분담하였습니다.

- 매 주 **Google Meet**를 사용하여 회의하고, 회의 시간을 잊지 않도록 회의 전에 서로 리마인드하기로 하였습니다.

- 매주 회의 시간에 각 팀원의 담당 업무를 확인하고, 진행 상황을 공유할 수 있도록 **Notion**을 사용하였습니다.

- 프로젝트 진행은 다음과 같은 단계로 기획하였습니다.

    - **기획**: 팀 구성, 요구사항 분석
  
    - **설계**: UI/VIEW 설계, 비즈니스 로직 설계, DB Schema 설계, Model 설계, Controller 클래스 설계

    - **개발**: DB 구축, VIEW 구현, Model 구현, Controller 클래스 구현, Prototype 완성

    - **테스트**: 시나리오 작성, 최종 테스트

    - **완성**: 최종 보고서 작성, 결과물 제출
 
 ### 2. 요구사항 분석

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

### 3. UI/UX 설계

- 앞서 작성한 Use-case에 따라 필요한 입력 및 출력 화면을 정의하고, 간단한 그림으로 UI를 **Kakao Oven**을 사용하여 설계하였습니다.

  - 다음 링크를 누르시면 자세한 UI 설계 내용을 확인할 수 있습니다.
  
  - [so-so-market Kakao Oven Link](https://ovenapp.io/view/eCW3HIbZ8KcDWxVHeLJ5soTCYyFbJgrT#7PTcT)

  - 해당 UI는 추후 와이어프레임으로 재설계되었습니다.

- 각 화면 내의 입력 창, 체크박스 버튼, 드롭 다운 메뉴 등 필요한 UI 컴포넌트를 구상하였습니다.

- 각 화면에 대한 이름을 정의하고, 화면들 사이의 연결관계를 설계하였습니다.

- 서비스 아이콘을 클릭하면 메인 화면으로 이동하는 등, 다양한 사용자 시나리오를 작성하였습니다.

### 4. Domain 클래스 설계

- 앞서 설계한 요구사항의 실행을 위해 **draw.io**를 사용하여 기본적으로 필요한 Domain 클래스들을 설계하였습니다.

- 각 클래스에 필요한 필드의 타입과 이름, 메서드를 정의하고 간략한 설명을 포함하였습니다.

- 클래스들 간의 상속, 구성, 연관 관계를 표현하였습니다.

### 5. DB Schema 설계

- 논리적 모델링과 물리적 모델링 단계를 거쳐 데이터를 영속적으로 저장하고 관리하는 Database Schema를 설계하였습니다.

- Use-case와 Domain 클래스를 바탕으로, 엔티티의 속성, 식별자, 연관 관계를 정의하였습니다. 각 요소의 설명을 주석으로 추가하여 **논리적 모델링**을 수행하였습니다.

    - **erwin**을 사용하여 ER Diagram을 작성하였습니다.

- 논리적 모델링을 바탕으로, 각 엔티티를 테이블로 변환하고, 각 테이블 간 연관 관계를 고려하여 **물리적 모델링**을 수행하였습니다. 또한, 각 테이블의 컬럼, 제약 조건, PK 등을 정의하고, 각 요소의 설명을 주석으로 추가하여 **물리적 모델링**을 수행하였습니다.

    - **Oracle SQL Devoper**를 사용하여 Table Schema를 작성하였습니다.
 
### 6. DAO 설계

- DAO는 Service 클래스에서 호출됩니다.

- Domain 클래스와 관련된 데이터를 Database와 연동하는 계층으로, 관련 기능을 정의하였습니다.

- **인터페이스 정의**

    - 각 Domain 클래스에 대한 인터페이스를 정의하였습니다.
  
    - Domain 클래스의 데이터를 다루는 메서드들을 선언하였습니다.

- **클래스 정의**

    - 앞서 정의한 인터페이스를 구현한 클래스를 정의하였습니다.
  
    - 각 메서드 내에서는 Mapper 인터페이스를 호출합니다.

    - 각 메서드는 필요에 따라, 적절한 객체를 반환합니다.

- **Mapper 인터페이스 정의**

    - MyBatis를 사용하여 Database와 상호작용하기 위해, 앞서 구현한 클래스의 메서드를 선언하여 Mapper 인터페이스를 정의하였습니다.

- **Mapper.xml 정의**

    - SQL 질의문을 작성하여 Mapper 인터페이스에 정의된 메서드를 구현하였습니다.
  
    - Mapper 인터페이스와 매핑하는 코드를 작성합니다.

    - DB Schema에 기반하여 SQL 질의문을 작성하였습니다.
 
### 7. Controller 클래스 정의

- 앞서 설계한 Use-case의 요청을 처리할 Controller 클래스들을 정의하였습니다.
 
- Domain 클래스를 기반으로 Form Controller 클래스와 Command 클래스를 정의하였습니다.

### 8. Service 클래스 정의

- Controller에서의 요청 처리 작업을 하기 위해, Service 클래스에서 각 메서드 별 역할을 수행할 수 있도록 DAO 클래스를 활용하여 SosoMarketFacade Service 인터페이스를 정의하였습니다.

- SosoMarketFacade 인터페이스를 구현한 SosoMarketImpl 클래스를 정의하였습니다.

### 9. Request 처리 흐름 정의

- Controller에서의 요청 처리 작업을 하기 위해, Service 클래스에서 각 메서드 별 역할을 수행할 수 있도록 DAO 클래스를 활용하여 SosoMarketFacade Service 인터페이스를 정의하였습니다.

- SosoMarketFacade 인터페이스를 구현한 SosoMarketImpl 클래스를 정의하였습니다.

- 다음 링크를 누르시면 자세한 Request Mapping 내용을 확인할 수 있습니다.

- [so-so-market Google Sheets](https://docs.google.com/spreadsheets/d/1fe1fcmk3U99QAK8U8Nj6eXWwVl_a3t45R8zvjZ1bkjA/edit#gid=0)

## 🌖 기능 구현

### ***데이터 생성(C), 검색(R), 갱신(U), 삭제(D) 요청에 따른 기능 구현 방식 및 데이터 이동 흐름***

- **사용자 요청 처리 (JSP Page → Controller)**

  사용자가 특정 이벤트를 발생시키면, 해당 이벤트의 사용자 요청 URI와 매핑된 Controller를 `@RequestMapping` 으로 찾아, 사용자 요청을 Controller에 전달합니다.

- **데이터 검증 (Controller)**

  Controller는 사용자 요청과 입력 데이터를 받은 후, 적절한 **Validator**를 호출하여 데이터를 검증합니다.

- **Service 클래스 호출 (Controller → Service)**

  Controller는 검증된 데이터를 바탕으로, 해당 요청에 대한 Database 작업을 수행하기 위해 `@Autowired`로 주입된 Service 인터페이스의 관련 메서드를 호출합니다.

- **DAO 클래스 호출 (Service → DAO)**

  Service 인터페이스를 구현한 Service 클래스의 관련 메서드에서 `@Autowired`를 통해 주입받은 DAO 객체의 관련 메서드를 실행합니다.

- **Database 연동 (DAO → Database → Service → Controller)**

  DAO 클래스에서는 MyBatis를 통해 작성한 SQL 쿼리가 실행되고, 필요에 따라 결과 객체를 반환합니다. 해당 결과는 다시 Service Layer를 통해 Controller로 전달됩니다.

- **결과 반환 및 페이지 전환 (Controller → JSP Page)**

  작업이 완료되면 Controller는 ModelAndView, Model, String 등 다양한 Return Type을 사용하여 사용자에게 결과를 반환하거나 적절한 페이지로 사용자를 안내합니다.

---

### ***사용자 입력 양식(Form)의 초기화 및 처리 방식***

- **사용자 이벤트 (JSP Page)**

    - **Form 화면으로 이동하는 이벤트**

      ```<a href=’<c:url value=”uri_address”/>’>```와 같이 **GET 방식**으로 사용자 요청 URI를 생성합니다.

    - **Form을 작성한 후 데이터를 처리하는 이벤트**

      ```<form:form modelAttribute=”command_name” method=”post”>```와 같이 **POST방식**으로 사용자 요청 URI를 생성합니다.

- **Form 초기화 및 생성 (Controller::formBacking)**

  Form의 구성 요소와 대응되는 Command 객체를 생성하고 초기 값들을 설정합니다.

- **Form 표시 (Controller::GET 요청 처리)**

  사용자가 Form을 작성하기 위해 버튼을 클릭하면, ```@RequestMapping(method=RequestMethod.GET)```으로 지정된 메서드가 호출됩니다. 이 메서드는 ```formBacking()``` 메서드에 의해 생성되고 초기화된 Command 객체를 Form 화면에 전달하여, 초기화된 값을 포함한 Form 화면을 사용자에게 제공합니다.

- **Form 제출 (Controller::POST 요청 처리)**

  사용자가 Form을 작성한 후 버튼을 클릭하면, ```@RequestMapping(method=RequestMethod.POST)```으로 지정된 메서드가 호출됩니다. 이 메서드에서 ```@ModelAttribute(”command_name”)```로 지정된 매개변수를 통해 ```formBacking()``` 메서드에 의해 생성된 Command 객체에 Form에서 입력된 값들이 저장되어 참조할 수 있습니다. 해당 메서드 내에서 적절한 작업을 수행하고 사용자에게 적절한 화면을 반환합니다.

---

### ***이미지 파일 업로드 기능***

- **JSP 페이지**

  HTML 파일에서 ```<form>``` 태그의 ```enctype``` 속성 값을 ```“multipart/form-data”```로 설정하였습니다.

- **Bean & Maven Dependency 설정**

  Multipart 형식의 데이터를 Controller에서 사용할 수 있도록 Commons FileUpload API를 이용한 MultipartResolver Bean을 생성하고 Maven Dependency에 common-fileupload를 추가하였습니다.

- **Controller**

    - MultipartHttpServletRequest 의 ```getFile(”imageFile”)``` 메서드를 통해 사용자가 업로드한 이미지 파일을 가져옵니다.
    
    - 파일명의 중복을 방지하기 위해, Spring framework에서 제공하는 MultipartFile의 메서드를 사용한 ```UUID.randomUUID().toString() + “_” + imageFile.getOriginalFileName();``` 코드를 작성함으로써 새로운 파일명을 생성하였습니다.
    
    - 새로운 파일명을 활용하여 File 객체를 생성하였습니다.
    
    - 서버 파일 시스템에 ```imageFile.transferTo(File)```을 사용하여 사용자가 업로드한 imageFile을 저장하였습니다.
 
---

### ***경매 마감시간이 지나면 자동으로 낙찰 처리가 진행되도록 하는 기능***

- **사용자 경매 상품 등록 (JSP Page)**

  사용자가 Form에 경매 상품과 관련된 정보를 입력한 후 버튼을 클릭하여 사용자 요청 URI를 생성합니다.

- **경매 상품 등록 처리 (Controller)**

  사용자가 입력한 정보를 바탕으로, SchedulerService 클래스의 testScheduler 메서드를 호출하여 경매상품의 마감 시간과 경매 상품의 ID를 매개변수로 전달합니다.

- **SchedulerService 클래스 설정 (SchedulerService)**

  ```@Service```와 ```@Transactional```을 통해 해당 클래스를 Spring에서 관리되는 Bean으로 정의하고 트랜잭션 처리를 지원하도록 구성되었습니다.

- **경매 상품 마감 후 작업 지정 (SchedulerService::testScheduler)**

    - 매개변수로 전달받은 마감 시간과 Spring에서 제공하는 TaskScheduler를 사용한 ```scheduler.schedule(updateTableRunner, closingTime);``` 코드를 통해, 시스템에서 마감 시간이 되면 Runnable 인터페이스의 객체인 updateTableRunner 에서 구현한 작업을 수행하도록 예약하였습니다.
    
    - updateTableRunner는 Runnable 인터페이스를 구현한 익명 내부 클래스로, 지정한 마감 시간이 되면 실행되는 작업이 정의되어있습니다. 해당 클래스의 ```run()``` 메서드에서는 매개변수로 전달받은 경매 상품의 ID를 사용하여 Database에 주문을 생성하고, 경매 상품의 상태를 업데이트 하는 등의 작업을 수행합니다.

## 🌗 프로젝트 설정 및 실행 방법

### 1. Remote so-so-market Repository 를 본인의 Eclipse Local Repository에 Clone 합니다.

### 2. Local Repository의 so-so-market 프로젝트를 Eclipse WorkSpace로 import하고, Java EE View로 확인합니다.

### 3. 한글 Encoding을 다음과 같은 순서로 설정합니다.

  - Window -> Preferences -> Editors -> Text Editors -> Spelling -> Encoding -> Other: UTF-8 체크 -> Apply

  - Window -> Preferences -> General -> Workspace -> Text file encoding -> Other: UTF-8 체크 -> Apply

  - Window -> Preferences -> General -> Content Types -> Java Class File, Text -> Default encoding: UTF-8 입력 -> Update -> Apply and Close

  - Window -> Preferences -> Web -> CSS Files, HTML Files, JSP Files -> Encoding: UTF-8 입력 -> Apply and Close

  - Window -> Preferences -> XML -> XML Files -> Encoding: UTF-8 입력 -> Apply and Close

  - so-so-market 프로젝트 우클릭 -> Properties -> Resource -> Text file encoding -> Other: UTF-8 체크 -> Apply

### 4. Apache Tomcat을 설치합니다.

### 5. so-so-market 프로젝트의 Dynamic Web Module과 Tomcat의 버전을 호환되도록 맞춥니다.
  
  - [Dynamic Web Module과 Tomcat 버전 호환하는 방법](https://dark-cloud-covered-sunshine.tistory.com/27)

### 6. so-so-market 프로젝트를 Tomcat에 적재합니다.

### 7. 프로젝트 전체실행 버튼을 클릭합니다.
