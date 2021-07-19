package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "students", catalog = "NETAS")
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID")
	private int id;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "DISTRICT")
	private String district;
	
	@Column(name = "MOBILE_PHONE_NUMBER")
	private String mobilePhoneNumber;
	
	@Column(name = "STUDENT_NAME")
	private String studentName;
	
	@Column(name = "STUDENT_SURNAME")
	private String studentSurname;
	

}
