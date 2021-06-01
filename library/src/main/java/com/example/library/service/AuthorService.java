package com.example.library.service;

import com.example.library.dto.NewAuthorDTO;
import com.example.library.entity.Author;

public interface AuthorService {

    Author addNewAuthor(NewAuthorDTO newAuthorDTO);

}
