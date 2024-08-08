package com.api.book.booksApi.controller;

import com.api.book.booksApi.entities.Books;
import com.api.book.booksApi.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Basic REST API...
//In next parts, will cover CRUD
@RestController
public class BooksController {

    //autowiring booksService to use in controller
    @Autowired
    private BooksService service;

    //Get all books (Get)
    @GetMapping("/books")
    public List<Books> getAll(){
        return this.service.findAllBooks();
    }

    //Add books (Post)
    @PostMapping("/books")
    public Books addbook(@RequestBody Books book){
        Books bk = this.service.addbook(book);
        return bk;
    }

    //Delete a book (Delete)
    @DeleteMapping("/books/{bookNo}")
    public void deleteBook(@PathVariable("bookNo") int bookNo){
        this.service.deletBook(bookNo);
    }


}
