package com.klu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.klu.model.Book;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        for(Book b : books) {
            if(b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public int getCount() {
        return books.size();
    }
}