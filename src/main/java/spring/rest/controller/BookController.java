package spring.rest.controller;

import io.swagger.annotations.ApiParam;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.rest.model.Book;
import spring.rest.repository.BookRepository;
import spring.rest.service.BookService;

import javax.validation.constraints.NotBlank;
import java.awt.print.Pageable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    private BookRepository bookRepository;

    @PostMapping(value = "/books")
    public ResponseEntity<?> create(@RequestBody Book book) {
        bookService.create(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> read() {
        final List<Book> books = bookService.readAll();

        return books != null &&  !books.isEmpty()
                ? new ResponseEntity<>(books, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*@GetMapping("books/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam("query") String query) {
        return ResponseEntity.ok(bookService.searchBooks(query));
    }*/

    /*@GetMapping
    public List<Book> findCustomersByFirstName(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("status") Status status, Pageable pageable) {

        if (firstName != null) {
            if (lastName != null) {
                if (status != null) {
                    return customerRepo.findByFirstNameAndLastNameAndStatus(
                            firstName, lastName, status, pageable);
                } else {
                    return customerRepo.findByFirstNameAndLastName(
                            firstName, lastName, pageable);
                }
            } else {
                // other combinations omitted for sanity
            }
        } else {
            // other combinations omitted for sanity
        }
    }*/

    @GetMapping("books/search_title")
    public ResponseEntity<List<Book>> findByTitle(@RequestParam("title") String title) {
        if (title != null) {
            return new ResponseEntity<>(bookRepository.findByTitle(title), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("books/search_author")
    public ResponseEntity<List<Book>> findByAuthor(@RequestParam("author") String author) {
        if (author != null) {
            return new ResponseEntity<>(bookRepository.findByAuthor(author), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("books/search_issue_start")
    public ResponseEntity<List<Book>> findByIssueStartDate(@RequestParam("issueStartDate") String issueStartDate) {
        if (issueStartDate != null) {
            return new ResponseEntity<>(bookRepository.findByIssueStartDate(Date.valueOf(issueStartDate)), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("books/search_issue_end")
    public ResponseEntity<List<Book>> findByIssueEndDate(@RequestParam("issueEndDate") String issueEndDate) {
        if (issueEndDate != null) {
            return new ResponseEntity<>(bookRepository.findByIssueEndDate(Date.valueOf(issueEndDate)), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
