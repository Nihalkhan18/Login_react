package com.student.tech.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.tech.dto.ResponseStructure;
import com.student.tech.dto.Student;
import com.student.tech.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
    private StudentRepository repository;

    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = repository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    public ResponseEntity<Student> getStudentById(Long id) {
        Optional<Student> student = repository.findById(id);
        return student.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Student> createStudent(Student student) {
        Student savedStudent = repository.save(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    public ResponseEntity<Student> updateStudent(Long id, Student student) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        student.setId(id);
        Student updatedStudent = repository.save(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteStudent(Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<ResponseStructure<Student>> verifyStudent(String email, String password) {
		ResponseStructure<Student> structure = new ResponseStructure<>();
		List<Student> dbUser = repository.verifyStudent(email, password);
		try {
		if (dbUser.get(0)!=null) {
			structure.setMessage("Verification Succesfull");
			structure.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		}
		catch( Exception e) {
			
			structure.setMessage("invalid email or password ");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(structure);
	}

}
   



