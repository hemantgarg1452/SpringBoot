package com.api.book.booksApi.controller;

import com.api.book.booksApi.entities.Books;
import com.api.book.booksApi.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {

    @Autowired
    private BooksService service;


    //Get all books (Get)
    @GetMapping("/books")
    public ResponseEntity<List<Books>> getAll(){
        List<Books>list = service.findAllBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }


    //Add books (Post)
    @PostMapping("/books")
    public ResponseEntity<Books> addbook(@RequestBody Books book){
        try{
            Books bk = this.service.addbook(book);
            return ResponseEntity.of(Optional.of(bk));
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //Delete a book (Delete)
    @DeleteMapping("/books/{bookNo}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookNo") int bookNo){
        try{
            this.service.deletBook(bookNo);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //Update a book details (PUT)
    @PutMapping("/books/{bookNo}")
    public ResponseEntity<Books> updateBook(@PathVariable("bookNo") int bookNo, @RequestBody Books book){
        try{
            Books updatedBook = this.service.updateBook(bookNo,book);
            if(updatedBook!=null){
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedBook);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
