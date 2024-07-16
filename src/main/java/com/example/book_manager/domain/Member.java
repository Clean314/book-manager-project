package com.example.book_manager.domain;

import com.example.book_manager.listener.MemberEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data // getter, setter, toString, equals, hashCode (call super 경고 왜?)
@Builder // 빌더 생성 제공
@Entity // JPA 어노테이션. Id 필드 필수
@EntityListeners(value = {AuditingEntityListener.class, MemberEntityListener.class})
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

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}