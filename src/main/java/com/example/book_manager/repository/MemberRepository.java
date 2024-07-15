package com.example.book_manager.repository;


import com.example.book_manager.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Set<Member> findByName(String name);

    Set<Member> findMemberByNameIs(String name);
    Set<Member> findMemberByName(String name);
    Set<Member> findMemberByNameEquals(String name);

    Member findByEmail(String email);

    Member getByEmail(String email);
    Member readByEmail(String email);
    Member queryByEmail(String email);
    Member searchByEmail(String email);
    Member streamByEmail(String email);
    Member findMemberByEmail(String email);
    Member findSomethingByEmail(String email);

    List<Member> findFirst2ByName(String name);
    List<Member> findTop2ByName(String name);
    List<Member> findLast1ByName(String name); // Last 는 작동하지 않고 Top 으로 작동한다.
    List<Member> findTopByNameOrderByIdDesc(String name); // 이렇게 하면 위에서 의도한 것으로 작동한다.
    List<Member> findTopByNameOrderByIdDescEmailAsc(String name); // 이름에 해당하는 멤버를 찾고 id는 내림차순, 동일한 이름이 여러 개일 경우 이메일로 오름차순

    List<Member> findByEmailAndName(String email, String name);
    List<Member> findByEmailOrName(String email, String name);

    List<Member> findByCreatedAtAfter(LocalDateTime yesterday);
    List<Member> findByIdAfter(Long id);
    List<Member> findByCreatedAtGreaterThan(LocalDateTime yesterday);
    List<Member> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);
    List<Member> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

    List<Member> findByIdBetween(Long id1, Long id2);
    List<Member> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    List<Member> findByIdIsNotNull();

    List<Member> findByNameIn(List<String> names);
    List<Member> findByNameStartingWith(String names);
    List<Member> findByNameEndingWith(String names);
    List<Member> findByNameContains(String names);
    List<Member> findByNameLike(String names);

    // 정렬
    List<Member> findByName(String name, Sort sort);

    // 페이징
    Page<Member> findByName(String names, Pageable pageable);

    // 메서드 호출 시 해당 네이티브 쿼리를 실행하고 결과를 반환한다.
    @Query(value = "select * from user limit 1;", nativeQuery = true)
    Map<String, Objects> findRawRecord(); // 키(DB에서의 열 이름), 값(해당하는 value) 형태의 값 1개를 담을 수 있다.
}
