package io.ranjith.mongoDbCrud.DAO;

import io.ranjith.mongoDbCrud.Entity.Book;
import io.ranjith.mongoDbCrud.Entity.BookUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class BookDAO {
    @Autowired
    private BookRepository bookRepository;


    public Collection<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.insert(book);
    }

    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> deleteBookById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(b -> bookRepository.delete(b));
        return book;
    }

    public Optional<Book> updateBookById(int id, BookUpdatePayload updatedBookDetails) {
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(b -> b.setTitle(updatedBookDetails.getTitle()));
        book.ifPresent(b -> b.setAuthor(updatedBookDetails.getAuthor()));
        book.ifPresent(b -> bookRepository.save(b));

        book = bookRepository.findById(id);
        return book;
    }
}
