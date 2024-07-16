package com.example.book_manager.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
@EntityListeners({AuditingEntityListener.class})
public class Book extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;
}
