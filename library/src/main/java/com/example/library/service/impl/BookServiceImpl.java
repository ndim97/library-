package com.example.library.service.impl;

import com.example.library.dto.NewAuthorDTO;
import com.example.library.dto.NewBookDTO;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.exception.BookNameAlreadyExists;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorServiceImpl authorService;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorServiceImpl authorService, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addNewBook(NewBookDTO newBookDTO, NewAuthorDTO newAuthorDTO) throws BookNameAlreadyExists {

        if(newBookDTO.getBookName() == null || newBookDTO.getBookName().isEmpty() ){
            throw new IllegalArgumentException("Book name is not provided");
        }

        if (bookRepository.findFirstByBookName(newBookDTO.getBookName()).isPresent() ){
            //throw new IllegalArgumentException("Book name is already exists!");
            throw new BookNameAlreadyExists("Book name is already exists!");
        }

        if(newAuthorDTO.getAuthorName() == null || newAuthorDTO.getAuthorName().isEmpty()){
            throw new IllegalArgumentException("Author name is not provided");
        }

        Book book = new Book();
        book.setBookName(newBookDTO.getBookName());
        book.setPublicationYear(newBookDTO.getPublicationYear());

        newAuthorDTO = authorRepository.findFirstByAuthorName(newAuthorDTO.getAuthorName())
                .orElse(authorService.addNewAuthor(newAuthorDTO));


        book.setAuthor((Author) newAuthorDTO);
        bookRepository.save(book);

        return book;
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book updateBook(Long id, NewBookDTO newBookDTO, NewAuthorDTO newAuthorDTO) {

        if(!newBookDTO.getBookName().equals(bookRepository.findById(id).get().getBookName())){
            throw new IllegalArgumentException("Book name is not the same");
        }

        if(newAuthorDTO.getAuthorName() == null || newAuthorDTO.getAuthorName().isEmpty()){
            throw new IllegalArgumentException("Author name is not provided");
        }

        Book book = new Book();
        book.setId(id);
        book.setBookName(newBookDTO.getBookName());
        book.setPublicationYear(newBookDTO.getPublicationYear());

        newAuthorDTO = authorRepository.findFirstByAuthorName(newAuthorDTO.getAuthorName())
                .orElse(authorService.addNewAuthor(newAuthorDTO));

        book.setAuthor((Author) newAuthorDTO);
        bookRepository.save(book);

        return book;
    }

}
