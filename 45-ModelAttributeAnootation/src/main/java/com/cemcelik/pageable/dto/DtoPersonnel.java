package com.cemcelik.pageable.dto;

import com.cemcelik.pageable.model.Department;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoPersonnel {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Department department;

}
