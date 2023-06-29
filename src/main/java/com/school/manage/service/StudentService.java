package com.school.manage.service;

import com.school.manage.Entity.StudentEntity;
import com.school.manage.exception.GenericException;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<?>addStudent(StudentEntity studentEntity)throws GenericException;
    ResponseEntity<?>getAllStudent()throws GenericException;
    ResponseEntity<?>getByIdStudent(long id)throws GenericException;
    ResponseEntity<?>updateStudent(StudentEntity studentEntity,long id)throws GenericException;
    ResponseEntity<?>deleteStudent(long id)throws GenericException;
}
