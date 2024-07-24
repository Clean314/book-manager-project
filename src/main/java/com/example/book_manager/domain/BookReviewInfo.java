package com.example.book_manager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 1:1 관계. 실제 db 에서는 아이디 참조 형태로 저장됨
    // optional = false 는 null 을 허용하지 않는다는 뜻
    // mappedBy 는 해당 테이블에서는 연관 키를 가지지 않게 설정하는 것 (join 여러 번 피하기 위힘)
    @OneToOne(optional = false)
    private Book book;

    // 대문자 Float 또는 Int 는 null 을 허용하기 때문에 null 체크 필요해짐
    private float averageReviewScore;

    private int reviewCount;
}
