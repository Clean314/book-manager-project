package com.example.book_manager.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass // 이 클래스를 다른 엔티티 클래스의 부모 클래스로 지정하겠다는 말. 이 클래스는 직접 엔티티로 사용할 수 없다.
@EntityListeners(AuditingEntityListener.class) // 리스너 지정. AuditingEntityListener 는 엔티티 생성, 수정될 때마다 시간 정보 자동 기록
public class BaseEntity implements Auditable{
    // MappedSuperclass 이므로 아래 필드들은 자식 클래스의 테이블에 매핑된다.

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}