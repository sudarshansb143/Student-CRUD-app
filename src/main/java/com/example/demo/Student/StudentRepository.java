package com.example.demo.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//This is for the data access
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("Select s from Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
