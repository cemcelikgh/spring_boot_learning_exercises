package com.cemcelik.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cemcelik.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {}
