package io.ranjith.mongoDbCrud.Controller;

import io.ranjith.mongoDbCrud.Entity.BookUpdatePayload;
import io.ranjith.mongoDbCrud.Service.BookService;
import io.ranjith.mongoDbCrud.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // get all the books from mongodb
    @GetMapping // if you want to add any extra route you can add -> @GetMapping("/getAllBooks") like this
    public Collection<Book> getBooks(){
        return bookService.getBooks();
    }

    // add the book to the Database collection.
    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    // get the book details by ID
    @GetMapping(value = "/{id}")
    public Optional<Book> getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    // delete book by id
    @DeleteMapping(value = "/{id}")
    public Optional<Book> deleteBookById(@PathVariable int id){
        return bookService.deleteBookById(id);
    }

    // Update book by id and other values
    // for this operation we need separate class because we are only updating the title and author.
    // So we are using BookUpdatePayload class for that.
    @PutMapping(value = "/{id}")
    public Optional<Book> updateBookById(@PathVariable int id, @RequestBody BookUpdatePayload updatedBookDetails){
        return bookService.updateBookById(id, updatedBookDetails);
    }
}
