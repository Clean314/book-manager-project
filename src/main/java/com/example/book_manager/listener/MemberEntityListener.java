package com.example.book_manager.listener;

import com.example.book_manager.domain.Member;
import com.example.book_manager.domain.MemberHistory;
import com.example.book_manager.repository.MemberHistoryRepository;
import com.example.book_manager.support.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class MemberEntityListener {

//    @Pre: 엔티티가 영속 상태가 되기 전에 실행
//    @Post: 엔티티가 데이터베이스에 저장된 후 실행
    @PostPersist
    @PostUpdate
//    @PrePersist
//    @PreUpdate
    public void prePersistAndPreUpdate(Object o) {
        // Listener 는  @Component 등록을 해도 Bean 주입 불가
        MemberHistoryRepository memberHistoryRepository =
                BeanUtils.getBean(MemberHistoryRepository.class);

        Member member = (Member) o;

        MemberHistory memberHistory = new MemberHistory();
        memberHistory.setMemberId(member.getId());
        memberHistory.setName(member.getName());
        memberHistory.setEmail(member.getEmail());
        memberHistory.setMember(member);

        memberHistoryRepository.save(memberHistory);
    }
}