package com.claim.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.claim.entity.Teacher;
import com.claim.respository.TeacherRepository;
@RestController
@CrossOrigin
@RequestMapping(value="/teacher")
public class TeacherController {
	
@Autowired
private TeacherRepository teacherRepository;

@RequestMapping(value="/findById",
         produces=MediaType.APPLICATION_JSON_VALUE,
         method=RequestMethod.GET)
public ResponseEntity<Optional<Teacher>> findById(Long id) {
	Optional<Teacher> teacher = this.teacherRepository.findById(id);
	return new ResponseEntity<>(teacher, HttpStatus.OK);
	}

@RequestMapping(value="/findAll",
produces=MediaType.APPLICATION_JSON_VALUE,
method=RequestMethod.GET)
public ResponseEntity<List<Teacher>> findAll() {
List<Teacher> teacher = this.teacherRepository.findAll();
return new ResponseEntity<>(teacher, HttpStatus.OK);
}

@RequestMapping(value="/findByEmail",
produces=MediaType.APPLICATION_JSON_VALUE,
method=RequestMethod.GET)

public ResponseEntity<Teacher> findByEmail(String email) {
Teacher teacher = this.teacherRepository.findByEmail(email);
return new ResponseEntity<>(teacher, HttpStatus.OK);
}

@RequestMapping(value="/findByLastName",
        produces=MediaType.APPLICATION_JSON_VALUE,
		method=RequestMethod.GET)
@ResponseBody
public ResponseEntity<List<Teacher>> findByLastName(String lastName){
List<Teacher> teacher = this.teacherRepository.findByLastName(lastName);
return new ResponseEntity<>(teacher, HttpStatus.OK);
}
}



