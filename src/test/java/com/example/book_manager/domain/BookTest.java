package com.example.book_manager.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookTest {

    @Test
    void crudTest(){
        Book book = new Book();
        book.setName("bookName");
        book.setCategory("Category");
        book.setAuthorId(1L);

        System.out.println(">>> Book Test");
        System.out.println(book);
    }
}