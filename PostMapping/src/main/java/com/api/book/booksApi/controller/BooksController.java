package com.api.book.booksApi.controller;

import com.api.book.booksApi.entities.Books;
import com.api.book.booksApi.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//Basic REST API...
//In next parts, will cover CRUD
@RestController
public class BooksController {

    //autowiring booksService to use in controller
    @Autowired
    private BooksService service;

    //Get all books
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

}
