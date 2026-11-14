package com.cemcelik.exception_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cemcelik.dto.DtoEmployee;
import com.cemcelik.service.IEmployeeService;

@SpringBootTest(classes = { ExceptionManagementApplication.class })
class ExceptionManagementApplicationTests {

	@Autowired
	private IEmployeeService employeeService;

	@AfterEach
	public void afterEach() {
		System.out.println("afterEach çalıştı");
	}

	@Test
	public void testFindEmployeeById() {
		DtoEmployee employee = employeeService.findEmployeeById(8L);

		if (employee != null) {
			System.out.println("Çalışanın ismi: " + employee.getName());
		}

		assertNotNull(employee);

		assertEquals(8, employee.getId());

	}

	@BeforeEach
	public void beforeEach() {
		System.out.println("afterEach çalıştı");
	}

}
