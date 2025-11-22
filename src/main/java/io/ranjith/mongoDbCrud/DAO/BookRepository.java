package io.ranjith.mongoDbCrud.DAO;

import io.ranjith.mongoDbCrud.Entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {
}
