package com.example.book_manager.repository;

import com.example.book_manager.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest(){
        Book book = new Book();
        book.setName("Book Name");
        book.setAuthor("Author");

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }
}