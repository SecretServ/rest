package spring.rest.service;

import spring.rest.model.Book;

import java.util.List;

public interface BookService {

    void create(Book book);

    List<Book> readAll();

    Book read(Integer id);

    //List<Book> searchBooks(String query);

    boolean update(Book book, Integer id);

    boolean delete(Integer id);
}
