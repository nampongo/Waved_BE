# 🌊 Riding the Wave of Challenges Toward Employment with WAVED

<img width="5760" height="4096" alt="image" src="https://github.com/user-attachments/assets/cc9d5dbd-0c08-4725-8c5a-e56ec00420cd" />  
<img width="5760" height="4096" alt="image" src="https://github.com/user-attachments/assets/572f3015-00a4-4081-a55b-35dbef48c0b0" />  
<img width="5760" height="4096" alt="image" src="https://github.com/user-attachments/assets/22f5fa2c-568f-4f32-ab1c-1ece1351dd50" />  
<br>


## 💡 Project Overview

**WAVED** is a challenge-based platform designed to motivate and support developers preparing for employment.  
Users can join various sessions, set personal goals, and build consistency through daily certification and community interaction.

### 🔹 Key Features
- **Personalized Challenges:** Tailored challenge sessions designed for developers preparing for jobs.  
- **Motivational System:** Users deposit participation fees as a commitment incentive and earn rewards upon completion.  
- **Flexible Verification Methods:** Each challenge supports customized verification types (image, text, GitHub, link).  
- **Community Interaction:** Participants can share progress and feedback with peers in the same challenge session.  
<br>


## 🔗 Service Link
[https://waved-likelion.site/](https://waved-likelion.site/) *(service discontinued)*  
<br>


## 🗓️ Development Period
- **Development:** Feb 26, 2024 – Mar 22, 2024  
- **Testing & Refactoring:** Apr 1, 2024 – Apr 26, 2024  
<br>


## 👥 Team
### Backend ×2 | Frontend ×3 | Designer ×2  
<img width="5760" height="4096" alt="image" src="https://github.com/user-attachments/assets/adb4e9bb-7524-4fcc-af50-7516e363aae5" />  
<br>


## 🛠️ Tech Stack & Tools
<div align="left"> 
  <img height="38" src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <img height="38" src="https://img.shields.io/badge/OAuth2.0-43853D?style=flat-square&logo=OAuth&logoColor=white"/>
  <img height="38" src="https://img.shields.io/badge/JWT-000000?style=flat-square&logo=JSONWebTokens&logoColor=white"/>
  <img height="38" src="https://img.shields.io/badge/lombok-C02E18?style=for-the-badge&logo=lombok&logoColor=white"><br>    
  <img src="https://img.shields.io/badge/SpringDataJPA-53B421?style=for-the-badge&logo=SpringDataJPA&logoColor=white">
  <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"><br>
  <img src="https://img.shields.io/badge/redis-DC382D?style=for-the-badge&logo=redis&logoColor=white">
  <img src="https://img.shields.io/badge/azure-0078D4?style=for-the-badge&logo=microsoft-azure&logoColor=white">
  <img src="https://img.shields.io/badge/azure%20storage-0089D6?style=for-the-badge&logo=microsoft-azure&logoColor=white"><br>  
</div>
<br>


## 📘 API Documentation
📎 [Postman API Spec](https://documenter.getpostman.com/view/34016201/2sA3JRXds2)
<br><br>


## 🗂️ Database Schema
<img width="1358" height="668" alt="image" src="https://github.com/user-attachments/assets/1eac1d10-7ba3-44c5-92e9-20a28544b645" />  
<br>


## 📁 Package Structure
```
src
└── main
    ├── java/com/senity/waved
    │     ├── base
    │     │     └── config, exception, jwt, redis, security
    │     ├── common
    │     └── domain
    │           ├── admin, challenge, challengeGroup, event, liked, member,
    │           │ myChallenge, notification, paymentRecord, quiz, review, verification
    │           └── Each includes controller, service, repository, dto, entity
    └── resources
          ├── application.yml
          └── application-secret.yml
```
<br>


## ⚙️ Features

### 🧩 A. Authentication — Google OAuth 2.0 + JWT Token
- Integrated **Spring Security** with **Google OAuth 2.0** for authentication.  
- Used **Redis** for managing refresh tokens.  
- Implemented **blacklist handling** to block logged-out tokens until expiry.
<br>


### 📸 B. Multiple Challenge Verification Types
Users can verify progress via **image, text, link, or GitHub commit**.  
- **Image verification:** Uploaded via multipart and stored in **Azure Blob Storage**.  
- **GitHub verification:** Integrated with **GitHub API** to check daily commit activity.  

<img width="5760" height="4096" alt="image" src="https://github.com/user-attachments/assets/da1e6cb8-4af0-4269-89c6-367ab269733a" />  
<img width="5760" height="4096" alt="image" src="https://github.com/user-attachments/assets/c58cba72-aa6b-4068-a245-800ee96891e2" />  
<br>


### ❤️ C. Like & Review System
Implemented **transaction-level isolation** to ensure data consistency during concurrent like events.  
Even with multiple simultaneous likes, transaction isolation prevents dirty reads and maintains atomicity.
<br><br>


### ⏰ D. Automated Challenge Generation
Originally, each challenge session had to be created manually.  
Added **scheduling and auto-generation logic** to create new challenge sessions dynamically,  
improving operational efficiency and data accuracy.
<br><br>


### 💳 E. Payment Integration (PortOne API)
Integrated with **PortOne API** for the entire payment process:  
payment verification, post-payment validation, cancellation, and refund handling.
<br><br>

### 🔔 F. Real-Time Notification (SSE)
Implemented **real-time notifications** using **Spring SSE (Server-Sent Events)**.  
Admins can immediately notify users about canceled verifications or status updates.
<br><br>

### 🧯 G. Exception Handling
Defined a **global exception handler** for consistent error response structure across the API.  
Each exception type returns an appropriate HTTP status code and message,  
reducing redundancy and improving collaboration.

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
}
```
<br>

## 🚀 Performance Optimization & Issues
### 1️⃣ Query Optimization — Partial Select
<br>
Observed unnecessary data loading and tested multiple partial query methods for performance improvement.

a. Performance Tests
```bash
Test1 - Elapsed time: 112 ms  # Default entity query
Test2 - Elapsed time: 673 ms  # QueryDSL partial select
Test3 - Elapsed time: 601 ms  # Projection partial select
Test4 - Elapsed time: 471 ms  # DTO partial select
```
b. Query Analysis
Compared full entity vs DTO projections —
<br>
DTO-based partial select improved readability and maintenance but had higher overhead,
so the default entity query was retained for efficiency.
```bash
 
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

c. Memory Usage
<br>
```bash
Test1 - Elapsed time: 103 ms  | Memory: 4,527,440 bytes  
Test2 - Elapsed time: 564 ms  | Memory: 23,068,640 bytes  
```
Result: ~5× higher memory usage in DTO-based queries → reverted to full entity select.
<br><br>

### 2️⃣ Object-Relation Optimization

Due to session-based challenge structure, complex relationships caused redundant data loading.

<br>
a. Redefined JPA Mappings
<br>
Removed unnecessary relationships and optimized entity mappings.
<br>
Maintained referential integrity using explicit foreign key constraints.
<br><br>
b. Entity–DTO Conversion
<br>
Introduced DTO conversion to achieve separation of concerns,
<br>
improving flexibility and maintainability of service layers.
<br><br>
Result:
<br>
Prevented infinite loops during entity fetching.
<br>
Reduced query calls, improving load time from 3s → 1s on “My Challenge” page.
