package com.example.library.dto;

import com.example.library.entity.Author;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class NewAuthorDTO{

    @NotNull
    private String authorName;

    public NewAuthorDTO() {

    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

}
