package com.school.manage.repository;

import com.school.manage.Entity.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffMember,Long> {
}
