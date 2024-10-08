package com.example.book_manager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MemberHistory extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", insertable = false, updatable = false)
    private Long memberId;

    private String name;

    private String email;

    @ManyToOne
    private Member member;
}