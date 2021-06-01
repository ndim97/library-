package com.example.library.service;

import com.example.library.dto.NewAuthorDTO;
import com.example.library.dto.NewBookDTO;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.exception.BookNameAlreadyExists;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book addNewBook(NewBookDTO newBookDTO, NewAuthorDTO newAuthorDTO) throws BookNameAlreadyExists;

    Book getBookById(Long id);

    Book updateBook(Long id, NewBookDTO newBookDTO, NewAuthorDTO newAuthorDTO);
}
