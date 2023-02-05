package com.example.bootrestbookapplication.dao;

import com.example.bootrestbookapplication.Entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book,Integer> {
    public Book findById(int id);
}
