package com.example.library.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class NewBookDTO {

    @NotNull
    private String bookName;

    private String publicationYear;

    @NotNull
    private String authorName;

    public NewBookDTO() {

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

}
