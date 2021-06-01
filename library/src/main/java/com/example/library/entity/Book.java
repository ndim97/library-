package com.example.library.entity;

import com.example.library.dto.NewBookDTO;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends NewBookDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "year_of_publication")
    private String publicationYear;

    @ManyToOne(targetEntity = Author.class, optional = false)
    private Author author;

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
