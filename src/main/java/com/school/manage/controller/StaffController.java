package com.school.manage.controller;

import com.school.manage.Entity.StaffMember;
import com.school.manage.exception.GenericException;
import com.school.manage.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;
    @PostMapping
    ResponseEntity<?> addStaff(@Valid @RequestBody StaffMember staffMember) throws GenericException {
        return  staffService.addStaff(staffMember);
    }
    @GetMapping("/")
    ResponseEntity<?>getStaffs(){
        return staffService.getStaffs();
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getStaffById(@PathVariable("id") long id) throws GenericException {
        return staffService.getStaffById(id);
    }
    @PutMapping("/{id}")
    ResponseEntity<?>updateStaff(@Valid @RequestBody StaffMember staffMember, @PathVariable("id") long id) throws GenericException {
        return staffService.updateStaff(staffMember, id);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?>deleteStaff(@PathVariable long id) throws GenericException {
        return staffService.deleteStaff(id);
    }

}
