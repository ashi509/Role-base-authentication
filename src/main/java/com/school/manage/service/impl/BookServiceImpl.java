package com.school.manage.service.impl;

import com.school.manage.Entity.BookEntity;
import com.school.manage.exception.GenericException;
import com.school.manage.repository.BookRepository;
import com.school.manage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public ResponseEntity<?> addBook(BookEntity bookEntity) throws GenericException {
      bookEntity.setId(0);
    var book=bookRepository.save(bookEntity);
    if(book==null)
        throw new GenericException(HttpStatus.NOT_FOUND.value(), "Something went wrong book not added");
    return ResponseEntity.status(HttpStatus.CREATED).body(book);

        }

    @Override
    public ResponseEntity<?> getAllBook() throws GenericException {
    var book= bookRepository.findAll();
    if(book.isEmpty())
        throw new GenericException(HttpStatus.BAD_REQUEST.value(), "No any book here");
    return ResponseEntity.ok(book);
    }

    @Override
    public ResponseEntity<?> getByIdBook(long id) throws GenericException {
       var book=bookRepository.findById(id).orElseThrow(()->
               new GenericException(HttpStatus.NOT_FOUND.value(),"Book not found with given id "+id));
    return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @Override
    public ResponseEntity<?> updateBook(BookEntity bookEntity, long id) throws GenericException{
        var book=bookRepository.findById(id).orElseThrow(()->
                new GenericException(HttpStatus.NOT_FOUND.value(),"Book not found with given id "+id));
        bookEntity.setId(id);
        book= bookRepository.save(bookEntity);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @Override
    public ResponseEntity<?> deleteBook(long id) throws GenericException {
        var book=bookRepository.findById(id).orElseThrow(()->
                new GenericException(HttpStatus.NOT_FOUND.value(),"Book not found with given id "+id));
        bookRepository.deleteById(id);
        return ResponseEntity.ok(book);
    }
}
