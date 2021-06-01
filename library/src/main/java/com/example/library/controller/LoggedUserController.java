package com.example.library.controller;

import com.example.library.dto.NewAuthorDTO;
import com.example.library.dto.NewBookDTO;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.exception.BookNameAlreadyExists;
import com.example.library.service.impl.BookServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoggedUserController extends BaseController {

    private final BookServiceImpl bookService;

    public LoggedUserController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @PreAuthorize("isAuthenticated()") //трябва да е без ! знак
    @GetMapping("/books")
    public ModelAndView viewAllBooks(){
        return send("books", "bookList", bookService.getAllBooks());
       // return send("books");
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/books/add")
    public ModelAndView addNewBook(){
         return send("add-book");
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/books/add")
    public ModelAndView addNewBook(@ModelAttribute NewBookDTO newBookDTO, @ModelAttribute NewAuthorDTO newAuthorDTO) throws BookNameAlreadyExists {
        bookService.addNewBook(newBookDTO, newAuthorDTO);
        return redirect("/books");
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/books/edit/{id}")
    public ModelAndView updateBook(@PathVariable Long id){
        return send("edit-book", "book", bookService.getBookById(id));
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/books/edit/{id}")
    public ModelAndView updateBook(@PathVariable Long id, @ModelAttribute NewBookDTO newBookDTO, @ModelAttribute NewAuthorDTO newAuthorDTO) {
        bookService.updateBook(id, newBookDTO, newAuthorDTO);
        return redirect("/books");
    }

}
