package com.school.manage.service.impl;

import com.school.manage.Entity.StudentEntity;
import com.school.manage.exception.GenericException;
import com.school.manage.repository.StudentRepository;
import com.school.manage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public ResponseEntity<?> addStudent(StudentEntity studentEntity) throws GenericException {
        studentEntity.setId(0);
        studentEntity.setCreatedDate(new Date());
        var student=studentRepository.save(studentEntity);
        if(student==null)
        throw new GenericException(HttpStatus.NO_CONTENT.value(), "Something went wrong");
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @Override
    public ResponseEntity<?> getAllStudent() throws GenericException {
        var student=studentRepository.findAll();
        if(student.isEmpty())
            throw new GenericException(HttpStatus.NO_CONTENT.value(),"Something went wrong student not Found");
    return ResponseEntity.ok(student);
    }

    @Override
    public ResponseEntity<?> getByIdStudent(long id) throws GenericException {
     var student=studentRepository.findById(id).orElseThrow(()->
             new GenericException(HttpStatus.NOT_FOUND.value(),"Student not found with given id "+id));
     return ResponseEntity.ok(student);
    }

    @Override
    public ResponseEntity<?> updateStudent(StudentEntity studentEntity, long id) throws GenericException {
        var student=studentRepository.findById(id).orElseThrow(()->
                new GenericException(HttpStatus.NOT_FOUND.value(),"Student not found with given id "+id));
     studentEntity.setId(id);
     studentEntity.setCreatedDate(new Date());
    student=studentRepository.save(studentEntity);
    return ResponseEntity.ok(student);
    }

    @Override
    public ResponseEntity<?> deleteStudent(long id) throws GenericException {
        var student=studentRepository.findById(id).orElseThrow(()->
                new GenericException(HttpStatus.NOT_FOUND.value(),"Student not found with given id "+id));
        studentRepository.deleteById(id);
        return ResponseEntity.ok(student);
    }
}
