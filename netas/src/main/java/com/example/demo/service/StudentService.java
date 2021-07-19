package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student createStudent(Student student) {
		studentRepository.save(student);
		return student;
	}
	
	public List<Student> viewStudent(Student student) {
		return studentRepository.findAll();
	}

	public Student updateStudent(Student student) {
		studentRepository.save(student);
		return student;
	}
	
	public Student deleteStudent(Student student) {
		studentRepository.delete(student);
		return student;
	}
}
