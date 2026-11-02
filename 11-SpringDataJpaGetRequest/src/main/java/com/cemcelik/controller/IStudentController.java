package com.cemcelik.controller;

import java.util.List;

import com.cemcelik.entities.Student;

public interface IStudentController {

	public Student saveStudent(Student student);

	public List<Student> getAllStudents();

}
