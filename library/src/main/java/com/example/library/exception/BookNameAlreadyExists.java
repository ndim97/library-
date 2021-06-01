package com.example.library.exception;

public class BookNameAlreadyExists extends Exception{

    public BookNameAlreadyExists(String message){
        super(message);
    }

    public BookNameAlreadyExists(String message, Throwable err){
        super(message, err);
    }
}
