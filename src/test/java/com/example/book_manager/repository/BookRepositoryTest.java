package com.example.book_manager.repository;

import com.example.book_manager.domain.Book;
import com.example.book_manager.domain.Member;
import com.example.book_manager.domain.Publisher;
import com.example.book_manager.domain.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void crudTest(){
        // id 관련 문제는 Book.class 참고
        Book book = new Book();
        book.setName("Book Name");
        book.setCategory("category");
        book.setAuthorId(1L);

        bookRepository.save(book);

        System.out.println(">>> BookRepository Test");
        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    void relationTest(){
        givenBookAndReview();

        Member member = memberRepository.findById(1L).orElseThrow();

        System.out.println("Reviews : " + member.getReviews());
        System.out.println("Books : " + member.getReviews().get(0).getBook());
        System.out.println("Publisher : " + member.getReviews().get(0).getBook().getPublisher());
    }

    private void givenBookAndReview(){
        givenReview(givenMember(), givenBook(givenPublisher()));
    }

    private Member givenMember(){
        return memberRepository.findById(1L).orElseThrow();
    }

    private Book givenBook(Publisher publisher){
        Book book = new Book();
        book.setName("Book Name");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }

    private Publisher givenPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("Publisher Name");

        return publisherRepository.save(publisher);
    }

    private void givenReview(Member member, Book book){
        Review review = new Review();
        review.setTitle("좋은 책");
        review.setContent("재미있게 봤어요.");
        review.setScore(4.0f);
        review.setMember(member);
        review.setBook(book);

        reviewRepository.save(review);
    }
}