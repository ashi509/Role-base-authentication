package com.school.manage.controller;

import com.school.manage.Entity.BookEntity;
import com.school.manage.exception.GenericException;
import com.school.manage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping()
    ResponseEntity<?> addBook(@Valid @RequestBody BookEntity bookEntity)throws GenericException{
        return bookService.addBook(bookEntity);
    }
    @GetMapping("/")
    ResponseEntity<?>getAllBook()throws GenericException{
        return bookService.getAllBook();
    }
    @GetMapping("/{id}")
    ResponseEntity<?>getByIdBook(@PathVariable("id") long id)throws GenericException{
        return bookService.getByIdBook(id);
    }
    @PutMapping("/{id}")
    ResponseEntity<?>updateBook(@Valid @RequestBody BookEntity bookEntity,@PathVariable("id") long id)throws GenericException{
        return bookService.updateBook(bookEntity,id);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?>deleteBook(@PathVariable("id") long id)throws GenericException{
        return bookService.deleteBook(id);

    }
}
