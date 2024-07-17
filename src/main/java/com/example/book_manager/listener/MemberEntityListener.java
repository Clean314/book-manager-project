package com.example.book_manager.listener;

import com.example.book_manager.domain.Member;
import com.example.book_manager.domain.MemberHistory;
import com.example.book_manager.repository.MemberHistoryRepository;
import com.example.book_manager.support.BeanUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class MemberEntityListener {
    @PrePersist
    @PreUpdate
    public void prePersistAndPreUpdate(Object o) {
        // Listener 는  @Component 등록을 해도 Bean 주입 불가
        MemberHistoryRepository memberHistoryRepository =
                BeanUtils.getBean(MemberHistoryRepository.class);

        Member member = (Member) o;

        MemberHistory memberHistory = new MemberHistory();
        memberHistory.setMemberId(member.getId());
        memberHistory.setName(member.getName());
        memberHistory.setEmail(member.getEmail());

        memberHistoryRepository.save(memberHistory);
    }
}