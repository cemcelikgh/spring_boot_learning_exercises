package com.cemcelik.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	private List<String> addMapValue(List<String> list, String newValue) {
		list.add(newValue);
		return list;
	}

//	private ApiError createApiError(Map<String, List<String>> errors) {
	private <T> ApiError<T> createApiError(T errors) {
//		ApiError apiError = new ApiError();
		ApiError apiError = new ApiError<T>();
		apiError.setId(UUID.randomUUID().toString());
		apiError.setErrorTime(new Date());
		apiError.setError(errors);
		return apiError;
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, List<String>> errorMap = new HashMap<>();
		for (ObjectError objErr : ex.getBindingResult().getAllErrors()) {
			String fieldName = ((FieldError) objErr).getField();
			if (errorMap.containsKey(fieldName)) {
				errorMap.put(fieldName, addMapValue(errorMap.get(fieldName), objErr.getDefaultMessage()));
			} else {
				errorMap.put(fieldName, addMapValue(new ArrayList<>(), objErr.getDefaultMessage()));
			}
		}
		return ResponseEntity.badRequest().body(createApiError(errorMap));
	}

}
