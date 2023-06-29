package com.school.manage.service.impl;

import com.school.manage.Entity.StaffMember;
import com.school.manage.exception.GenericException;
import com.school.manage.repository.StaffRepository;
import com.school.manage.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;
    @Override
    public ResponseEntity<?> addStaff(StaffMember staffMember) throws GenericException {
       staffMember.setId(0);
       var staff=staffRepository.save(staffMember);
       if(staff==null)
           throw new GenericException(HttpStatus.BAD_REQUEST.value(), "Something went wrong staff not save");
       return ResponseEntity.status(HttpStatus.CREATED).body(staff);
    }
    @Override
    public ResponseEntity<?> getStaffs() {
        return ResponseEntity.ok(staffRepository.findAll());
    }
    @Override
    public ResponseEntity<?> getStaffById(long id) throws GenericException {
       var staff=staffRepository.findById(id).orElseThrow(()->
               new GenericException(HttpStatus.NOT_FOUND.value(),"Given id is not found with id "+id));
        return ResponseEntity.ok(staff);
    }
    @Override
    public ResponseEntity<?> updateStaff(StaffMember staffMember, long id) throws GenericException {
        var staff=staffRepository.findById(id).orElseThrow(()->
                new GenericException(HttpStatus.NOT_FOUND.value(),"Given id is not found with id "+id));
        staffMember.setId(id);
        staff=staffRepository.save(staffMember);
        return ResponseEntity.ok(staff);
    }
    @Override
    public ResponseEntity<?> deleteStaff(long id) throws GenericException {
        var staff=staffRepository.findById(id).orElseThrow(()->
                new GenericException(HttpStatus.NOT_FOUND.value(),"Given id is not found with id "+id));
       staffRepository.deleteById(id);
      return ResponseEntity.ok(staff);

    }

}
