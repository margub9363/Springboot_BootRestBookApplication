package com.example.bootrestbookapplication.controllers;

import com.example.bootrestbookapplication.Entities.Book;
import com.example.bootrestbookapplication.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

//    BookService bookService = new BookService();
    @Autowired
    BookService bookService;


    @GetMapping("/books")
    ResponseEntity<List<Book>> getBooks() {
        List list = bookService.getAllBooks();
        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    /*
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
        Book book = null;
        try {
            book = bookService.getSingleBookById(id);
            if(book==null ){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.of(Optional.of(book));
        } catch ( Exception e){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//            ResponseEntity.of(Optional.of(bookService.getSingleBookById(id)));
        }
        return ResponseEntity.of(Optional.of(book));
    }
    */
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
        Book book = null;
        try {
            book = bookService.getSingleBookById(id);
            } catch ( Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }


    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book b = null;
        try {
            b = bookService.addBook(book);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.of(Optional.of(b));
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
