package com.example.library.entity;

import com.example.library.dto.NewAuthorDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author extends NewAuthorDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "author_name", nullable = false, unique = true)
    private String authorName;

    @OneToMany(targetEntity = Book.class, mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Book> books;

    public Author() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

}
