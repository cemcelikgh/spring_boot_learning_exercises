package com.cemcelik.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.entities.Student;
import com.cemcelik.repository.StudentRepository;
import com.cemcelik.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	public StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

}
