package com.api.book.booksApi.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Books")
public class Books{

    @Id
    @Column(name="IDs")
    private int no;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Authors author;
    private int price;

    public Books() {
    }

    public Books(int no, String name, Authors author, int price) {
        this.no = no;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
