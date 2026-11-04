package com.cemcelik.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cemcelik.dto.DtoStudent;
import com.cemcelik.dto.DtoStudentIU;
import com.cemcelik.entities.Student;
import com.cemcelik.repository.StudentRepository;
import com.cemcelik.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	public StudentRepository studentRepository;

	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		Student student = new Student();
		BeanUtils.copyProperties(dtoStudentIU, student);
		Student studentFromDb = studentRepository.save(student);
		DtoStudent responce = new DtoStudent();
		BeanUtils.copyProperties(studentFromDb, responce);
		return responce;

	}

	@Override
	public List<DtoStudent> getAllStudents() {
		List<DtoStudent> dtoStudentList = new ArrayList<>();
		List<Student> studentListFromDb = studentRepository.findAll();
		for (Student student : studentListFromDb) {
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(student, dtoStudent);
			dtoStudentList.add(dtoStudent);
		}
		return dtoStudentList;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		Optional<Student> optinal = studentRepository.findById(id);
		if (optinal.isPresent()) {
			DtoStudent dtoStudent = new DtoStudent();
			Student studentFromDb = optinal.get();
			BeanUtils.copyProperties(studentFromDb, dtoStudent);
			return dtoStudent;
		}
		return null;
	}

	@Override
	public void deleteStudent(Integer id) {
		Optional<Student> optinal = studentRepository.findById(id);
		if (optinal.isPresent()) {
			studentRepository.delete(optinal.get());
		}
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU updatedDtoStudentIU) {
		Optional<Student> optinal = studentRepository.findById(id);
		if (optinal.isPresent()) {
			Student studentFromDb = optinal.get();
			studentFromDb.setFirstName(updatedDtoStudentIU.getFirstName());
			studentFromDb.setLastName(updatedDtoStudentIU.getLastName());
			studentFromDb.setBirthOfDate(updatedDtoStudentIU.getBirthOfDate());
			Student updatedStudent = studentRepository.save(studentFromDb);
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(updatedStudent, dtoStudent);
			return dtoStudent;
		}
		return null;
	}

}
