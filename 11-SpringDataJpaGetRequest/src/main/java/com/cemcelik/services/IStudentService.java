package com.cemcelik.services;

import java.util.List;

import com.cemcelik.entities.Student;

public interface IStudentService {

	public Student saveStudent(Student student);

	public List<Student> getAllStudents();

}
