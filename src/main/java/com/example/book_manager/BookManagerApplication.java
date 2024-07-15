package com.example.book_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

// EnableJpaAuditing 은 감사 기능을 활성화 함 (Thanks 기능 아님ㅋ)
// @CreatedDate, @LastModifiedDate 등을 사용할 수 있도록 한다
@EnableJpaAuditing
public class BookManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagerApplication.class, args);
	}

}
