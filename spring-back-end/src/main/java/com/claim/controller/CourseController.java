package com.claim.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claim.entity.Course;
import com.claim.entity.Teacher;
import com.claim.respository.CourseRepository;

@RestController
@CrossOrigin
@RequestMapping(value="/course")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;
	
	@RequestMapping(value="/findById",
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	public ResponseEntity<Optional<Course>> findById(Long id) {
		Optional<Course> course = this.courseRepository.findById(id);
		return new ResponseEntity<>(course, HttpStatus.OK);
		}
	@RequestMapping(value="/findAll",
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
			public ResponseEntity<List<Course>> findAll() {
			List<Course> course = this.courseRepository.findAll();
			return new ResponseEntity<>(course, HttpStatus.OK);
	
}
}
