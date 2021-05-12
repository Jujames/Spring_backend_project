package com.claim.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import com.claim.entity.Student;

import com.claim.respository.StudentRepository;
import com.claim.service.SendMail;

@RestController
@CrossOrigin
@RequestMapping(value="/student")
public class StudentController {
	@Autowired
	private SendMail sendMail;
	
	
	@Autowired
    private	StudentRepository studentRepository;
	   
 @RequestMapping(value="/save", 
			 consumes=MediaType.APPLICATION_JSON_VALUE, 
			 method=RequestMethod.POST)
     public void submitStudentDetails(@RequestBody Student student) { 		 
       
		this.studentRepository.save(student);
		this.sendMail.send(student.getEmail(),"Welcome","Hello " );
		
 }
		@RequestMapping(value="/findById",
				produces=MediaType.APPLICATION_JSON_VALUE,
			    method=RequestMethod.GET)
		public ResponseEntity<Optional<Student>> findById(String email) {
		        
	Optional<Student> student = this.studentRepository.findById(email);
			
		 return new ResponseEntity<>(student, HttpStatus.OK);
		}	

         @RequestMapping(value="/findAll",
				produces=MediaType.APPLICATION_JSON_VALUE,
				method=RequestMethod.GET)
    public ResponseEntity<List<Student>> findAll() {
  List<Student> students = this.studentRepository.findAll();
			
  return new ResponseEntity<>(students, HttpStatus.OK);	
  }      
         
 @PostMapping(value="/login")
public ResponseEntity<Student> login(@RequestBody Student s) {
	
Student student = this.studentRepository.login(s.getEmail(), s.getPassword());
if( student == null) {
	return new ResponseEntity<> (HttpStatus.UNAUTHORIZED);
}
return new ResponseEntity<> (student, HttpStatus.OK);

  
}



}


