package com.api.book.booksApi.services;

import com.api.book.booksApi.Database.BookRepo;
import com.api.book.booksApi.entities.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BookRepo repo;

    //**************************************** GET Method ***************************************
    public List<Books> findAllBooks(){
        List<Books> list = (List<Books>) this.repo.findAll();
        return list;
    }

    //**************************************** POST Method ***************************************
    public Books addbook(Books b){
        return this.repo.save(b);
    }

    //**************************************** DELETE Method ***************************************
    public void deletBook(int bookNo) {
        this.repo.deleteById(bookNo);
    }

    //**************************************** PUT Method ***************************************
    public Books updateBook(int bookNo, Books book) {
        book.setNo(bookNo);
        return this.repo.save(book);
    }
}
