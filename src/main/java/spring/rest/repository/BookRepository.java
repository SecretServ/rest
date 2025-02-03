package spring.rest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.rest.model.Book;

import java.awt.print.Pageable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/*public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT p FROM Book p WHERE " +
            "p.title LIKE CONCAT('%',:query, '%')" +
            "Or p.description LIKE CONCAT('%', :query, '%')")
    List<Book> searchBooks(String query);
}*/


public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByIssueStartDate(Date issueStartDate);

    List<Book> findByIssueEndDate(Date issueEndDate);

    // other combinations omitted for sanity
}