package com.klu.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Book;
import com.klu.service.BookService;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private BookService service;

    // 2. /welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Library Application";
    }

    // 3. /count
    @GetMapping("/count")
    public int totalBooks() {
        return service.getCount();
    }

    // 4. /price
    @GetMapping("/price")
    public double bookPrice() {
        return 499.99;
    }

    // 5. /books
    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Java", "Spring Boot", "Hibernate", "Microservices");
    }

    // 6. /books/{id}
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return service.getBookById(id);
    }

    // 7. /search?title=Java
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    // 8. /author/{name}
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    // 9. /addbook
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        service.addBook(book);
        return "Book added successfully";
    }

    // 10. /viewbooks
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return service.getAllBooks();
    }
}