package com.school.manage.repository;

import com.school.manage.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity , Long> {
}
