<h1>Spring boot에서의 H2와 JPA 활용</h1>
<ol>
<li>초기 설정</li>
<li>Entity 만들기</li>
<li>data.sql (샘플 데이터)</li>
<li>페이징&정렬</li>
<li>Entity Listener 만들기</li>
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
    <h3>
      테스트 코드
    </h3>
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
    <h3>
      테스트 코드
    </h3>
    MemberRepositoryTest

<h2><li>Entity Listener 만들기</li></h2>
    <h3>Member 클래스, Listener 다이어그램</h3>
    <p>
        <img src="https://github.com/user-attachments/assets/288665a6-ad49-4538-8282-8a1ff6ec98f7">
    </p>
    *Bean 주입받기위한 support 클래스
    <p>
        <img src="https://github.com/user-attachments/assets/d6d9e61a-104d-4702-8b44-bd6cd94f7eae">
    </p>
    <h3>
      테스트 코드
    </h3>
    MemberRepositoryTest
</ol>

<!-- todo
자세한 설명 추가
관계성 --> 
