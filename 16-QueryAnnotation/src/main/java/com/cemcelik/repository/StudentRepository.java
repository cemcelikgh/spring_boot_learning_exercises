package com.cemcelik.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cemcelik.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	// HQL
	@Query(value = "from Student", nativeQuery = false)
	List<Student> findAllStudents();

	// SQL
//	@Query(value = "select * from student.student", nativeQuery = true)
//	List<Student> findAllStudents();

	// HQL
	@Query(value = "from Student s WHERE s.id= :studentId", nativeQuery = false)
	Optional<Student> findStudentById(Integer studentId);

}
