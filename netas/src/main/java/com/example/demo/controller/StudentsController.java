package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/")
public class StudentsController {
	
	private StudentRepository studentRepository;
	
	@Autowired
	public StudentsController(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	// get all students
	@GetMapping("/students")
	public List<Student> getAll() {
		return this.studentRepository.findAll();
	}
	
	// create student rest api
	@PostMapping("/students/add")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	// update student rest api
	@PostMapping("/students/update")
	public ResponseEntity<Student> updateStudent(@RequestParam int id, @RequestBody Student studentDetails) {
		Student student = studentRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		
		student.setStudentName(studentDetails.getStudentName());
		student.setStudentSurname(studentDetails.getStudentSurname());
		student.setMobilePhoneNumber(studentDetails.getMobilePhoneNumber());
		student.setCity(studentDetails.getCity());
		student.setDistrict(studentDetails.getDistrict());
		student.setDescription(studentDetails.getDescription());
		
		Student updatedStudent = studentRepository.save(student);
		
		return ResponseEntity.ok(updatedStudent);
	}
	
	// delete student rest api
	@DeleteMapping("/students/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable int id) {
		Student student = studentRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		
		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/students/getByIdStudents/{id}")
	public ResponseEntity<Student> getByIdStudent(@PathVariable int id) {
		Student student = studentRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		
		
		
		return ResponseEntity.ok(student);
	}
	
}
