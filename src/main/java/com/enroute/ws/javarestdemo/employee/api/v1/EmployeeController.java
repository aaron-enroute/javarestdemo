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

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public Iterable<Employee> retrieveAllUsers(@RequestParam(defaultValue = "1990-01-01") String hireDate)
			throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date date = dateFormat.parse(hireDate);
		return employeeService.getAllStartingFrom(date);

	}

	@GetMapping("/employee/{id}")
	public Optional<Employee> retrieveUser(@PathVariable Integer id) {
		return employeeService.findById(id);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee updateUser(@PathVariable("id") Integer id, @RequestBody Employee employee) throws SQLException, ClassNotFoundException {
		Optional<Employee> empService=employeeService.findById(id);
		Employee emp = empService.get();
		if (empService.isPresent()) {
			emp.setBirthDate(employee.getBirthDate());
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setGender(employee.getGender());
			emp.setTitles(employee.getTitles());
		}
		return employeeService.save(emp);
	}
}
