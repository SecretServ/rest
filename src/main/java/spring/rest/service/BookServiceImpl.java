package spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rest.model.Book;
import spring.rest.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void create(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> readAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book read(Integer id) {
        return bookRepository.getOne(id);
    }

    /*public List<Book> searchBooks(String query){
        List<Book> books = bookRepository.searchBooks(query);
        return books;
    }*/

    @Override
    public boolean update(Book book, Integer id) {
        if (bookRepository.existsById(id)) {
            bookRepository.save(book);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
