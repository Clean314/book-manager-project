package com.example.book_manager.domain;

import com.example.book_manager.listener.MemberEntityListener;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data // getter, setter, toString, equals, hashCode
@Builder // 빌더 생성 제공
@Entity // JPA 어노테이션. Id 필드 필수
@EntityListeners(value = {MemberEntityListener.class})
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Member extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER) // fetch 는 Lazy 오류 때문에
    @JoinColumn(name = "member_id", insertable = false, updatable = false) // OneToMany 에서는 중간 테이블 생성을 막기 위해 join 설정. member 엔티티에서는 history 값 insert/update 비활성화
    @ToString.Exclude // stackoverflow 방지
    private List<MemberHistory> memberHistories = new ArrayList<>(); // NullPointException 방지하기 위한 기본값

    @OneToMany
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();
}