package com.example.book_manager.repository;

import com.example.book_manager.domain.Book;
import com.example.book_manager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BookReviewInfoRepositoryTest {

    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void crudTest(){
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
//        bookReviewInfo.setBookId(1L);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(10);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>> bookReviewInfo Test");
        System.out.println(bookReviewInfoRepository.findAll());
    }

    @Test
    void crudTest2(){
        givenBookReviewInfo();

        Book result = bookReviewInfoRepository
                .findById(1L)
                .orElseThrow().getBook();

        System.out.println(" >>> result1 " + result);

        BookReviewInfo result2 = bookRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBookReviewInfo();

        System.out.println(" >>> result2 " + result2);
    }

    private Book givenBook(){
        Book book = new Book();
        book.setId(1L);
        book.setName("book name");
        book.setCategory("book category");
        book.setAuthorId(1L);

        return bookRepository.save(book);
    }

    private void givenBookReviewInfo(){
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(10);

        bookReviewInfoRepository.save(bookReviewInfo);
    }
}