package com.vn.ssl_be.domain.student.repository;

import com.vn.ssl_be.domain.lesson.dto.StudentQuestionResponse;
import com.vn.ssl_be.domain.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, String> {

}
