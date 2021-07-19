package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.model.Role;
import com.example.demo.model.Student;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;

@SpringBootApplication
@Component
public class NetasApplication implements CommandLineRunner {

	@Autowired
	RoleService roleService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(NetasApplication.class, args);

	}

	/*
	 * @PostConstruct public void addTestUser() { for(var i =0; i < 50 ; i++) {
	 * userRepository.save(User.builder().username(UUID.randomUUID().toString().
	 * substring(0, 15)) .password("password").build()); }
	 * 
	 * 
	 * }
	 */
	/*
	 * @PostConstruct public void addTestUser() { var students =
	 * studentRepository.count(); var restTemplate = new RestTemplate();
	 * 
	 * while (students < 50) {
	 * 
	 * try {
	 * 
	 * var response = restTemplate.getForEntity("https://randomuser.me/api/?nat=tr",
	 * HashMap.class); //HashMap<String, Object> studentData = (HashMap<String,
	 * Object>) ((List) studentData.getBody().get("results")).get(0);
	 * 
	 * 
	 * var nameField = studentData.get(") studentRepository.save(Student.builder()
	 * .studentName("") .studentSurname() .mobilePhoneNumber() .city() .district()
	 * .description() .build());
	 * 
	 * 
	 * } catch (Exception ex) { ex.printStackTrace(); }
	 * 
	 * 
	 * }
	 * 
	 * }
	 */

	
	
	public void run(String... args) throws Exception {
		// logger.info("Application started with command-line arguments: {} . \n To kill
		// this application, press Ctrl + C.", Arrays.toString(args));

		Role role1 = new Role();
		role1.setRoleName("Ogrenci kubra");
		role1.setUserLogin("kubbp");
		roleService.createRole(role1);
		
		Role role2 = new Role();
		role2.setRoleName("Software Engineer");
		role2.setUserLogin("egelim43");
		roleService.createRole(role2);
		
		Role role3 = new Role();
		role3.setRoleName("PHP Developer");
		role3.setUserLogin("mkerem");
		roleService.createRole(role3);
		
		
		Student st1 = new Student();
		st1.setId(1);
		st1.setCity("Mardin");
		st1.setDescription("Civil Engineer");
		st1.setDistrict("Midyat");
		st1.setMobilePhoneNumber("05336259952");
		st1.setStudentName("Halim");
		st1.setStudentSurname("Karaca");	
		studentService.createStudent(st1);
		
		Student st2 = new Student();
		st2.setId(2);
		st2.setCity("Urfa");
		st2.setDescription("Repairman");
		st2.setDistrict("Halfeti");
		st2.setMobilePhoneNumber("05447139562");
		st2.setStudentName("Hande");
		st2.setStudentSurname("Meral");		
		studentService.createStudent(st2);
		
		Student st3 = new Student();
		st3.setId(3);
		st3.setCity("Kayseri");
		st3.setDescription("Sales Manager");
		st3.setDistrict("Develi");
		st3.setMobilePhoneNumber("05531546223");
		st3.setStudentName("Hamit");
		st3.setStudentSurname("Kurt");
		studentService.createStudent(st3);
		
		
		User user1 = new User();
		user1.setUsername("gsoftware");
		user1.setPassword("pwd");
		userService.createUser(user1);
		
		User user2 = new User();
		user2.setUsername("silver");
		user2.setPassword("slv321");
		userService.createUser(user2);
		
		User user3 = new User();
		user3.setUsername("fatih.c");
		user3.setPassword("fth44");
		userService.createUser(user3);

	}
	

}
