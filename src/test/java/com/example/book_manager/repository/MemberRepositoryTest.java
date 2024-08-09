package com.example.book_manager.repository;


import com.example.book_manager.domain.Gender;
import com.example.book_manager.domain.Member;
import com.example.book_manager.domain.MemberHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    private MemberHistoryRepository memberHistoryRepository;

    @Test
    void jpaCreateTest(){
        Member member = new Member();
        memberRepository.save(member);
        System.out.println(">>> " + memberRepository.findAll());
    }

    @Test
    void matcherTest(){
        Member member = new Member();
        member.setEmail("slow");

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
        Example<Member> example = Example.of(member, matcher);

        System.out.println(">>> Matcher Test");
        memberRepository.findAll(example).forEach(System.out::println);
    }

    @Test
    void updateTest(){
        memberRepository.save(new Member("david", "david@fastemail.com"));

        Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        member.setEmail("martin-updated@fastemail.com");
        memberRepository.save(member);

        System.out.println(">>> Update Test");
        System.out.println(memberRepository.findById(1L).orElseThrow(RuntimeException::new));
    }

    @Test
    void select(){
        System.out.println(">>> findByCreatedAtAfter");
        memberRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)).forEach(System.out::println);
    }

    @Test
    void pagingAndSortingTest(){
        System.out.println(">>> findTopByNameOrderByIdDescEmailAsc");
        memberRepository.findTopByNameOrderByIdDescEmailAsc("martin").forEach(System.out::println);

        System.out.println(">>> findByName");
        memberRepository.findByName("martin", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))).forEach(System.out::println);

        System.out.println(">>> Paging findByName");
//        System.out.println(memberRepository.findByName("martin", PageRequest.of(1, 1, Sort.by(Sort.Order.desc("id")))).getTotalElements());
        memberRepository.findByName("martin", PageRequest.of(1, 1, Sort.by(Sort.Order.desc("id")))).forEach(System.out::println);
    }

    @Test
    void paging(){
        Page<Member> memberPage = memberRepository.findAll(PageRequest.of(1, 3)); // zero based 라서 1은 두 번째 페이지일 것임
        System.out.println("page : " + memberPage);
        System.out.println("totalElements : " + memberPage.getTotalElements()); // DB의 count 와 동일할 것임
        System.out.println("totalPages : " + memberPage.getTotalPages()); // 전체가 몇 페이지인지. (5//3=2) elements // size
        System.out.println("numberOfElements" + memberPage.getNumberOfElements()); // 현재 가져온 레코드 수
        System.out.println("sort : " + memberPage.getSort());
        System.out.println("size : " + memberPage.getSize()); // 페이징 크기

        memberPage.getContent().forEach(System.out::println); // getContent 로 내부 정보를 볼 수 있다.

        // entity 가 현재 5개이고, 한 페이지당 수(size)를 3개로 정했다. 그러니까 [1, 2, 3] 과 [4, 5] 로 나눠질 것이다.
        // 즉, PageRequest.of(0, 3) 는 첫 번째 페이지인 것이고 PageRequest.of(1, 3) 는 두 번째 페이지인 것이다.
    }

    @Test
    void enumTest(){
        Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        member.setGender(Gender.MALE);
        memberRepository.save(member);

        System.out.println(">>> ENUM test");
        memberRepository.findAll().forEach(System.out::println);

        System.out.println(">>> ");
        System.out.println(memberRepository.findRawRecord().get("gender"));
    }

    @Test
    void listenerTest(){
        Member member = new Member();
        member.setEmail("member2@fastemail.com");
        member.setEmail("martin");

        memberRepository.save(member);

        Member member2 = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        member2.setName("marrrrrtin");
        memberRepository.save(member2);

        memberRepository.deleteById(4L);

        System.out.println(">>> LISTENER test");
        memberRepository.findAll().forEach(System.out::println);
        memberHistoryRepository.findAll().forEach(System.out::println); // data.sql 에서 초기 데이터는 Listener 가 작동할 수 없어서 생성 히스토리는 없음
    }

    @Test
    void prePersistTest(){
        Member member = new Member();
        member.setEmail("member2@fastemail.com");
        member.setName("martin");

        memberRepository.save(member);

        System.out.println(memberRepository.findByEmail("martin2@fastemail.com"));
    }

    @Test
    void preUpdateTest(){
        Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        System.out.println("as-if : " + member);

        member.setName("martin22");
        memberRepository.save(member);

        System.out.println("to-be : "+memberRepository.findAll().get(0));
    }

    @Test
    void memberHistoryTest(){
        Member member = new Member();
        member.setEmail("martin-new@fastemail.com");
        member.setName("martin-new");

        memberRepository.save(member);

        member.setName("martin-new-new");

        memberRepository.findAll().forEach(System.out::println);
    }

    @Test
    void memberRelationTest(){
        Member member = new Member();
        member.setName("Zen");
        member.setEmail("zen@fastemail.com");
        member.setGender(Gender.FEMALE);

        memberRepository.save(member);

        System.out.println(">>> member findAll");
        memberRepository.findAll().forEach(System.out::println);

        member.setEmail("zen@slowemail.com");
        memberRepository.save(member);

        System.out.println(">>> memberHistory findAll");
        memberHistoryRepository.findAll().forEach(System.out::println);

        // 1) email 로 member 조회 후 memberId를 얻는다.
        // 2) memberId 로 history 를 조회한다.
//        List<MemberHistory> result = memberHistoryRepository.findByMemberId(
//                memberRepository.findByEmail("zen@slowemail.com").getId()
//        );

        // OneToMany 로 연결 후에 조회
        List<MemberHistory> result = memberRepository.findByEmail("zen@slowemail.com").getMemberHistories();

        // Member -> MemberHistory
        System.out.println(">>> findByEmail.getMemberHistory result");
        result.forEach(System.out::println);

        // MemberHistory -> Member
        System.out.println(">>> memberHistory.getMember (0) : " + memberHistoryRepository.findAll().get(0).getMember());

    }
}