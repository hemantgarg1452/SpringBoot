package com.api.book.booksApi.services;

import com.api.book.booksApi.entities.Books;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService {
    private static List<Books> list = new ArrayList<>();

    static {
        list.add(new Books(12, "You are not alone", "J.K. Gosh", 250));
        list.add(new Books(15, "Java & SpringBoot", "Telusko", 1600));
        list.add(new Books(52, "Cloud on Clouds", "Shreya Mehta", 2500));
        list.add(new Books(84, "Development to Deployment", "R. Porter", 3600));

    }
    //**************************************** GET Method***************************************
    //logic for get all books in list
    public List<Books> findAllBooks(){
        return list;
    }

    //**************************************** POST Method***************************************
    //logic for adding book in list
    public Books addbook(Books b){
        list.add(b);
        return b;
    }

    //**************************************** DELETE Method***************************************
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
}
