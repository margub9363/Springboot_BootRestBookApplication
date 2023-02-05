package com.example.bootrestbookapplication.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;

//    @Column(name="first_name")
    String firstName;

//    @Column(name="last_name")
    String lastName;

    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;
    public Author(int authorId) {
        this.authorId = authorId;
    }

    public Author(int authorId, String firstName, String lastName) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author() {

    }

    public int getAuthorId() {
        return authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
