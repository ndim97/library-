package com.example.library.controller;

import com.example.library.exception.BookNameAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler extends BaseController{

    @ResponseStatus(HttpStatus.CONFLICT) // или друг статус
    @ExceptionHandler(BookNameAlreadyExists.class)
    public ModelAndView bookAlreadyExists(BookNameAlreadyExists e) {
        return send("error/book-already-exists");
    }
}
