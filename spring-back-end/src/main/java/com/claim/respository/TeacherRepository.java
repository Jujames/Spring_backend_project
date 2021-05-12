package com.claim.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claim.entity.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	@Query("Select T from Teacher T where T.email = ?1")
public Teacher findByEmail(String email);
	
	@Query("Select T from Teacher T where T.lastName like %?1%" )
	List<Teacher> findByLastName( String lastName);

	
	
}
