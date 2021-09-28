package com.enroute.ws.javarestdemo.employee.api.v1;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enroute.ws.javarestdemo.model.Employee;
import com.enroute.ws.javarestdemo.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public Iterable<Employee> retrieveAllUsers(@RequestParam(defaultValue = "1990-01-01") String hireDate)
			throws ParseException {
		// String hireDate = "1990-01-01";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date date = dateFormat.parse(hireDate);
		return employeeService.getAllStartingFrom(date);

	}

	@GetMapping("/employee/{id}")
	public Optional<Employee> retrieveUser(@PathVariable Integer id) {
		return employeeService.findById(id);
	}

	// @PostMapping ("/employees")
	@RequestMapping(value = "/employees", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee createUser(@RequestBody Employee employee) throws SQLException, ClassNotFoundException {

		return employeeService.save(employee);
	}
}
