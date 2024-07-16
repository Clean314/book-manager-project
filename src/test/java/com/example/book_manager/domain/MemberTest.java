package com.example.book_manager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


// DB나 JPA 연결하지 않고 Member 클래스 자체를 테스트 함

class MemberTest {
    @Test
    void test(){
        Member member = new Member(); // NoArgs
        member.setEmail("martin@fastcampus.com");
        member.setName("martin");
        member.setCreatedAt(LocalDateTime.now());
        member.setUpdatedAt(LocalDateTime.now());

//        Member member1 = new Member(null, "martin", "martin@fastcampus.com", null, LocalDateTime.now(), LocalDateTime.now());
        Member member2 = new Member("martin", "martin@fastcampus.com");

        Member member3 = Member.builder()
                .name("martin")
                .email("martin@fastcampus.com")
                .build();

        System.out.println(">>> " + member.toString());
    }
}