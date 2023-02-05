package com.example.bootrestbookapplication.services;

import com.example.bootrestbookapplication.Entities.Book;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(12, "Java Complete Reference", "XYZ"));
        list.add(new Book(13, "Java Complete Reference", "ABC"));
        list.add(new Book(14, "Java Complete Reference", "DEF"));

    }

    //get all books
    public List<Book> getAllBooks() {
        return list;
    }

    // get single book by id
    /*
    public Book getSingleBookById(int id) {
        Book book = null;
        try {
            book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            return book;
        } catch (Exception e) {
            return null;
        }
    }
     */
    public Book getSingleBookById(int id) {
            Book book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            return book;
    }


    //        adding the book
    public Book addBook(Book b) {
        list.add(b);
        return b;
    }

    //        deleting the book
    public void deleteBook(int b_id) {
        list = list.stream().filter(book -> book.getId()!=b_id).collect(Collectors.toList());
    }

//    update the book
    public void updateBookByid(Book book, int bookId){
        list.stream().map( everySingleBook -> {
            if(everySingleBook.getId() == bookId) {
                everySingleBook.setTitle(book.getTitle());
                everySingleBook.setAuthor(book.getAuthor());
            }
            return everySingleBook;
        }).collect(Collectors.toList());

    }
}
