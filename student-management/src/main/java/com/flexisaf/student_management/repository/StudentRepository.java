package com.flexisaf.student_management.repository;

import com.flexisaf.student_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom JPQL Query to find students by course
    @Query("SELECT s FROM Student s WHERE s.course = :course")
    List<Student> findStudentsByCourse(String course);

    // Find active students
    List<Student> findByIsActiveTrue();
}
