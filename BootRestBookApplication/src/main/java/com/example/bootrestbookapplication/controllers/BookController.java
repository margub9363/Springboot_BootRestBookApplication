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

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id){
        return bookService.getSingleBookById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        Book b = bookService.addBook(book);
        return b;
    }

//    delete book handler
    @DeleteMapping("/books/{id}")
    public void deleteBookById(@PathVariable("id") int id){
        bookService.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        bookService.updateBookByid(book,id);
        return book;
    }

}
