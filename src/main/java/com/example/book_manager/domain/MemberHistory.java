package com.example.book_manager.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
@Data
@EntityListeners({AuditingEntityListener.class})
public class MemberHistory {
    @Id
    @GeneratedValue
    private Long id;

    private Long memberId;

    private String name;

    private String email;

}