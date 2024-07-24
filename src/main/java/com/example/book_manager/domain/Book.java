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
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 테이블마다 id sequence 를 분리한다.
    private Long id;

    private String name;

    private String category;

    private Long authorId;

    private Long publisherId;

    @OneToOne(mappedBy = "book")
    @ToString.Exclude // OneToOne 단방향이 아닐 때는 순환참조가 되기 때문에 한 쪽은 설정해줘야 함
    private BookReviewInfo bookReviewInfo;
}
