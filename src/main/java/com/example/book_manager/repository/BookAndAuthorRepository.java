package com.example.book_manager.repository;

import com.example.book_manager.domain.BookAndAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAndAuthorRepository extends JpaRepository<BookAndAuthor, Long> {
}
