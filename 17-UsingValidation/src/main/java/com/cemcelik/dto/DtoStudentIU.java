package com.cemcelik.dto;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

	@NotEmpty(message = "Ad boş bırakılamaz!")
	@Size(min = 3, max = 15, message = "Ad en fazla 10 harfli olmalıdır.")
	private String firstName;

	@Size(min = 3, max = 15)
	private String lastName;

	private Date birthOfDate;

}
