package com.school.manage.controller;

import com.school.manage.Entity.StudentEntity;
import com.school.manage.exception.GenericException;
import com.school.manage.service.StudentService;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
   @Autowired
   private StudentService studentService;
   @PostMapping()
    ResponseEntity<?> addStudent(@RequestBody StudentEntity studentEntity)throws GenericException{
        return studentService.addStudent(studentEntity);
    }
    @GetMapping("/")
    ResponseEntity<?>getAllStudent()throws GenericException{
       return studentService.getAllStudent();
    }
    @GetMapping("/{id}")
    ResponseEntity<?>getByIdStudent(@Valid @PathVariable long id)throws GenericException{
       return studentService.getByIdStudent(id);
    }
    @PutMapping("/{id}")
    ResponseEntity<?>updateStudent(@Valid @RequestBody StudentEntity studentEntity,@PathVariable long id)throws GenericException{
       return studentService.updateStudent(studentEntity,id);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?>deleteStudent(@PathVariable long id)throws GenericException{
       return studentService.deleteStudent(id);
    }



}
