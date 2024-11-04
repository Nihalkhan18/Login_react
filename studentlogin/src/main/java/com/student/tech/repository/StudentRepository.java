package com.student.tech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.student.tech.dto.Student;
@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s where s.email=?1 and password=?2")
	List<Student> verifyStudent(@Param(value = "email") String email, @Param(value = "password") String password);
    // Additional query methods can be defined here
}
