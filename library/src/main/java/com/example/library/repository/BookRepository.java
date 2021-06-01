package com.example.library.repository;

import com.example.library.entity.Book;
import com.example.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findFirstByBookName(String bookName);

}
