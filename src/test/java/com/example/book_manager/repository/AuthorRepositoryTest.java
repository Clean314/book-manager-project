package com.example.book_manager.repository;

import com.example.book_manager.domain.Author;
import com.example.book_manager.domain.Book;
import com.example.book_manager.domain.BookAndAuthor;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookAndAuthorRepository bookAndAuthorRepository;

    @Test
    @Transactional
    void manyToManyTest() {
        Book book1 = givenBook("책1");
        Book book2 = givenBook("책2");
        Book book3 = givenBook("book1");
        Book book4 = givenBook("book2");

        Author author1 = givenAuthor("author1");
        Author author2 = givenAuthor("author2");

//        book1.addAuthor(author1);
//        book2.addAuthor(author2);
//        book3.addAuthor(author1, author2);
//        book4.addAuthor(author1, author2);
//
//        author1.addBook(book1, book3, book4);
//        author2.addBook(book2, book3, book4);

        BookAndAuthor bookAndAuthor1 = givenBookAndAuthor(book1, author1);
        BookAndAuthor bookAndAuthor2 = givenBookAndAuthor(book2, author2);

        BookAndAuthor bookAndAuthor3 = givenBookAndAuthor(book3, author1);
        BookAndAuthor bookAndAuthor4 = givenBookAndAuthor(book3, author2);

        BookAndAuthor bookAndAuthor5 = givenBookAndAuthor(book4, author1);
        BookAndAuthor bookAndAuthor6 = givenBookAndAuthor(book4, author2);

        book1.addBookAndAuthors(bookAndAuthor1);
        book2.addBookAndAuthors(bookAndAuthor2);
        book3.addBookAndAuthors(bookAndAuthor3, bookAndAuthor4);
        book4.addBookAndAuthors(bookAndAuthor5, bookAndAuthor6);

        author1.addBookAndAuthors(bookAndAuthor1, bookAndAuthor3, bookAndAuthor5);
        author2.addBookAndAuthors(bookAndAuthor2, bookAndAuthor4, bookAndAuthor6);

        bookRepository.saveAll(Lists.newArrayList(book1, book2, book3, book4));
        authorRepository.saveAll(Lists.newArrayList(author1, author2));

        System.out.println(" >>> Book3 Authors ");
        bookRepository.findAll().get(2).getBookAndAuthors().forEach(o -> System.out.println(o.getAuthor()));
        System.out.println(" >>> Author1 Books ");
        authorRepository.findAll().get(0).getBookAndAuthors().forEach(o -> System.out.println(o.getBook()));

        // 3번 째 책의 모든 저자를 가져온다.
//        System.out.println(">>> Author through Book : " + bookRepository.findAll().get(2).getAuthors());
//        System.out.println(">>> Book through Author : " + authorRepository.findAll().get(0).getBooks());


    }

    Book givenBook(String name){
        Book book = new Book();
        book.setName(name);

        return bookRepository.save(book);
    }

    Author givenAuthor(String name){
        Author author = new Author();
        author.setName(name);

        return authorRepository.save(author);
    }

    BookAndAuthor givenBookAndAuthor(Book book, Author author){
        BookAndAuthor bookAndAuthor = new BookAndAuthor();
        bookAndAuthor.setBook(book);
        bookAndAuthor.setAuthor(author);

        return bookAndAuthorRepository.save(bookAndAuthor);
    }
}