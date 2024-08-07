package com.api.book.booksApi.services;

import com.api.book.booksApi.entities.Books;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BooksService {
    private static List<Books> list = new ArrayList<>();

    static {
        list.add(new Books(12, "You are not alone", "J.K. Gosh", 250));
        list.add(new Books(15, "Java & SpringBoot", "Telusko", 1600));
        list.add(new Books(52, "Cloud on Clouds", "Shreya Mehta", 2500));
        list.add(new Books(84, "Development to Deployment", "R. Porter", 3600));

    }

    public List<Books> findAllBooks(){
        return list;
    }


}
