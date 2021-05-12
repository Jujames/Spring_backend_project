package com.claim.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claim.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
	
@Query("Select S from Student S where S.email = ?1 and  S.password = ?2")
	public Student login(String email, String password);
	
}
