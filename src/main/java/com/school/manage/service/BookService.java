package com.school.manage.service;

import com.school.manage.Entity.BookEntity;
import com.school.manage.Entity.StudentEntity;
import com.school.manage.exception.GenericException;
import org.springframework.http.ResponseEntity;

public interface BookService {
    ResponseEntity<?> addBook(BookEntity bookEntity)throws GenericException;
    ResponseEntity<?>getAllBook()throws GenericException;
    ResponseEntity<?>getByIdBook(long id)throws GenericException;
    ResponseEntity<?>updateBook(BookEntity bookEntity,long id)throws GenericException;
    ResponseEntity<?>deleteBook(long id)throws GenericException;
}
