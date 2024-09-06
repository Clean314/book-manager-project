<h1>Spring boot에서의 H2와 JPA 활용</h1>
<ol>
<li>초기 설정</li>
<li>Entity 만들기</li>
<li>data.sql (샘플 데이터)</li>
<li>페이징&정렬</li>
<li>Entity Listener 만들기</li>
<li>관계 구현하기</li>
</ol>

<ol>
<h2><li>초기 설정</li></h2>
    <h3>추가한 의존성</h3>
    <ul>
        <li>H2</li>
        <li>Lombok</li>
    </ul>

<h2><li>Entity 만들기</li></h2>
    <h3>Member Entity 클래스, DB 다이어그램</h3>
    <p>
        <img src="https://github.com/user-attachments/assets/7e9ee2e6-4cfa-4d12-9e75-14bc1a18fa6c">
    </p>
    <h4>
        테스트 코드
    </h4>
    MemberRepositoryTest, MemberTest

<h2><li>data.sql (샘플 데이터)</li></h2>
    <p>
        <img src="https://github.com/user-attachments/assets/c18fa93a-b419-48ac-a3fe-81334c285ab3">
    </p>

<h2><li>페이징&정렬</li></h2>
    <h3>페이징 그림</h3>
    <p>
        <img src="https://github.com/user-attachments/assets/1581f881-9b89-4f66-aeef-8e25e3e08901">
    </p>
    <h4>
        테스트 코드
    </h4>
    MemberRepositoryTest

<h2><li>Entity Listener 만들기</li></h2>
    <h3>Member 클래스, Listener 다이어그램</h3>
    <p>
        <img src="https://github.com/user-attachments/assets/288665a6-ad49-4538-8282-8a1ff6ec98f7">
    </p>
    *Bean 주입받기위한 support 클래스
    <h3>리스너 수정</h3>
    <p>
        <img src="https://github.com/user-attachments/assets/ca3aa8d7-3594-420b-a3c7-d87082edc056">
    </p>
    <h4>
        테스트 코드
    </h4>

<h2><li>관계 구현하기</li></h2>
    <h3>1:1 관계</h3>
        <img src="https://github.com/user-attachments/assets/bde4dd96-77a2-4c19-ae2d-38ccd75d79c1">
        <h4>
            테스트 코드
        </h4>
        BookReviewInfoRepositoryTest.java
    <h3>1:N 관계</h3>
        <img src="https://github.com/user-attachments/assets/67730295-84a1-4765-b447-9603b2158355">
        <h4>
            테스트 코드
        </h4>
        MemberRepositoryTest
    <h3>N:1 관계</h3>
        <img src="https://github.com/user-attachments/assets/0f84a160-73b7-417b-acad-7a88ec3fb660">
        <h4>
            테스트 코드
        </h4>
        MemberRepositoryTest, BookRepositoryTest
    <h3>M:N 관계</h3>
        <img src="https://github.com/user-attachments/assets/736601fd-e792-4196-a0b5-7fe1e787c0c5">
        <h4>
            테스트 코드
        </h4>
        AuthorRepositoryTest
    <h3>전체 DB 다이어그램</h3>
        <img src="https://github.com/user-attachments/assets/dd29e202-dfa6-4f36-8921-000c0bb014f6">
    <h3>Entity 클래스 다이어그램</h3>
        <img src="https://github.com/user-attachments/assets/d082aeb5-8d38-442b-98a2-57a5e435dfdf">
</ol>
<!-- 클래스 관계도로 테이블 구현 -->
