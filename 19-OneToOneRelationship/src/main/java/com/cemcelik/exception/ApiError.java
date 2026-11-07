package com.cemcelik.exception;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//public class ApiError {
public class ApiError<T> {

	private String id;

	private Date errorTime;

//	private Map<String, List<String>> error;
	private T error;

}
