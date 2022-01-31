package io.ranjith.mongoDbCrud.Service;

import io.ranjith.mongoDbCrud.Entity.BookUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.ranjith.mongoDbCrud.Entity.Book;
import io.ranjith.mongoDbCrud.DAO.BookDAO;

import java.util.Collection;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    public Collection<Book> getBooks() {
        return bookDAO.getBooks();
    }

    public Book addBook(Book book) {
        return bookDAO.addBook(book);
    }

    public Optional<Book> getBookById(int id) {
        return bookDAO.getBookById(id);
    }

    public Optional<Book> deleteBookById(int id) {
        return bookDAO.deleteBookById(id);
    }

    public Optional<Book> updateBookById(int id, BookUpdatePayload updatedBookDetails) {
        return bookDAO.updateBookById(id, updatedBookDetails);
    }
}
