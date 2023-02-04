package com.example.bootrestbookapplication.controllers;

import com.example.bootrestbookapplication.Entities.Book;
import com.example.bootrestbookapplication.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

//    BookService bookService = new BookService();
    @Autowired
    BookService bookService;


    @GetMapping("/books")
    List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") int id){
        return bookService.getSingleBookById(id);
    }

}
