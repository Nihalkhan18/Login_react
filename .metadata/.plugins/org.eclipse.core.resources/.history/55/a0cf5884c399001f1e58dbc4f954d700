package com.student.tech.controller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.tech.dto.LoginDTO;
import com.student.tech.dto.ResponseStructure;
import com.student.tech.dto.Student;
import com.student.tech.service.StudentService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/api/students")
public class Studentcontrollers {
	  @Autowired
	    private StudentService service;

	    @GetMapping
	    public ResponseEntity<List<Student>> getAllStudents() {
	        return service.getAllStudents();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
	        return service.getStudentById(id);
	    }
	    

	    @PostMapping
	    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
	    	if (student.getEmail() == null || student.getEmail().isEmpty()) {
//	         
	    		return ResponseEntity.badRequest().build(); // Handle missing email
	        }
	        return service.createStudent(student);
	    }
	    

	    @PutMapping("/{id}")
	    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
	        return service.updateStudent(id, student);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
	        return service.deleteStudent(id);
	    }
	    
	    @PostMapping("/verify")
	    public ResponseEntity<ResponseStructure<Student>> verifyStudent(@RequestParam String email, @RequestParam String password  ){
	    	
	    	return service.verifyStudent(email, password);
	    }


}
