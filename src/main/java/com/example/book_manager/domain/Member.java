package com.example.book_manager.domain;

import com.example.book_manager.listener.MemberEntityListener;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data // getter, setter, toString, equals, hashCode
@Builder // 빌더 생성 제공
@Entity // JPA 어노테이션. Id 필드 필수
@EntityListeners(value = {MemberEntityListener.class})
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Member extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}