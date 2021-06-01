package com.example.library.service.impl;

import com.example.library.dto.NewAuthorDTO;
import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }

    @Override
    public Author addNewAuthor(NewAuthorDTO newAuthorDTO) {

        if(authorRepository.findFirstByAuthorName(newAuthorDTO.getAuthorName()) != null){
            Author author = new Author();
            author.setAuthorName(newAuthorDTO.getAuthorName());
            return author;
        }
        else {
            Author author = new Author();
            author.setAuthorName(newAuthorDTO.getAuthorName());
            authorRepository.save(author);

            return author;
        }
    }


}
