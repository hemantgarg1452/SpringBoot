package com.api.book.booksApi.Database;

import com.api.book.booksApi.entities.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Books, Integer> {

}
