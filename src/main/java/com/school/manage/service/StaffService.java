package com.school.manage.service;

import com.school.manage.Entity.StaffMember;
import com.school.manage.exception.GenericException;
import org.springframework.http.ResponseEntity;

public interface StaffService {
    ResponseEntity<?>addStaff(StaffMember staffMember) throws GenericException;
    ResponseEntity<?>getStaffs();
    ResponseEntity<?> getStaffById(long id) throws GenericException;
    ResponseEntity<?>updateStaff(StaffMember staffMember,long id) throws GenericException;
    ResponseEntity<?>deleteStaff(long id) throws GenericException;


}
