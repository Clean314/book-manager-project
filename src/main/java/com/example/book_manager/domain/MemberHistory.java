package com.example.book_manager.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
@Data
public class MemberHistory {
    @Id
    @GeneratedValue
    private Long id;

    private Long memberId;

    private String name;

    private String email;
}