package com.cemcelik.dto;

import org.hibernate.internal.build.AllowNonPortable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllowNonPortable
public class DtoCourse {

	private Long id;

	private String name;

}
