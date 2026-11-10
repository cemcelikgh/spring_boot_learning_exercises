package com.cemcelik.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowNonPortable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllowNonPortable
public class DtoStudent {

	private Integer id;

	private String firstName;

	private String lastName;

	private List<DtoCourse> courses = new ArrayList<>();

}
