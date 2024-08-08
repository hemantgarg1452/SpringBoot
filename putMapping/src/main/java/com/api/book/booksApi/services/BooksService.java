package com.api.book.booksApi.services;

import com.api.book.booksApi.entities.Books;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService {
    private static List<Books> list = new ArrayList<>();

    //**************************************** GET Method ***************************************
    //logic for get all books in list
    public List<Books> findAllBooks(){
        return list;
    }

    //**************************************** POST Method ***************************************
    //logic for adding book in list
    public Books addbook(Books b){
        list.add(b);
        return b;
    }

    //**************************************** DELETE Method ***************************************
    //logic for deleting a book in lis--> I used filter, the other simple approach is to use foreach and then if condition.
    public void deletBook(int bookNo) {
        // Using Filter (1st)
        list = list.stream().filter(book->book.getNo()!=bookNo).collect(Collectors.toList());

        //Using normal for loop method (2nd)
        boolean removed = false;

        // Iterate over the list to find and remove the book
        for (int i = 0; i < list.size(); i++) {
            Books book = list.get(i);
            if (book.getNo() == bookNo) {
                list.remove(i);
                removed = true;
                break;
            }
        }
    }

    //**************************************** PUT Method ***************************************
    public Books updateBook(int bookNo, Books book) {
        //filter method
        list = list.stream().map(bks ->{
            if(bks.getNo()==bookNo){
                bks.setName(book.getName());
                bks.setAuthor(book.getAuthor());
                bks.setPrice(book.getPrice());
            }
            return bks;
        }).collect(Collectors.toList());

        //for loop method
        for(Books bks : list){
            if(bks.getNo()==bookNo){
                bks.setName(book.getName());
                bks.setAuthor(book.getAuthor());
                bks.setPrice(book.getPrice());
            }
            return bks;
        }
        return null;
    }

}
