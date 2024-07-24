package com.example.book_manager.repository;

import com.example.book_manager.domain.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo, Long> {
}
