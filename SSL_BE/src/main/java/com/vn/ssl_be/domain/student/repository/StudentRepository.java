package com.vn.ssl_be.domain.student.repository;

import com.vn.ssl_be.domain.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
