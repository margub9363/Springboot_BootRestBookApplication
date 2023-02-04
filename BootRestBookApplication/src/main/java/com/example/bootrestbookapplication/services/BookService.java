package com.example.bootrestbookapplication.services;

import com.example.bootrestbookapplication.Entities.Book;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        public Book getSingleBookById(int id){
        Book book= null;
        book = list.stream().filter( e-> e.getId()==id).findFirst().get();
        return book;
        }
}
