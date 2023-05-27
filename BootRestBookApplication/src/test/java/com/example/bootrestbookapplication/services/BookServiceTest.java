package com.example.bootrestbookapplication.services;

import com.example.bootrestbookapplication.Entities.Book;
import com.example.bootrestbookapplication.dao.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepositoryMock;

    @InjectMocks
    BookService bookService;

    @Test
    void getSingleBookById_Test(){

        Book expected = new Book(200,"Testing with Mockito",null);
        when(bookRepositoryMock.findById(anyInt())).thenReturn(expected);
//        when
        Book expectedValue = new Book(200,"Testing with Mockito",null);
        Book actualValue = bookService.getSingleBookById(200);
//        then
        assertEquals(expected,actualValue);
    }

}