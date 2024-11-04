package com.student.tech.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

	@Entity
	@Data
	public class Student {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "username", nullable = false)
		private String username;
	    @Column(name = "phone", nullable = false, length = 10)
		private double phone;
	    @Column(name = "email", nullable = false, unique=true)
		private String email;
	    @Column(name = "gender", nullable = false)
		private String gender;
	    @Column(name = "password", nullable = false, unique=true)
		private String password;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public double getPhone() {
			return phone;
		}
		public void setPhone(double phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
		

	}


