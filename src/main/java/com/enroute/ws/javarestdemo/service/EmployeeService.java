package com.enroute.ws.javarestdemo.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enroute.ws.javarestdemo.model.Employee;
import com.enroute.ws.javarestdemo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	public Iterable<Employee> listAll() {

		return empRepo.findAll();
	}

	public Optional<Employee> findById(Integer id) {
		return empRepo.findById(id);
	}

	public Iterable<Employee> getAllStartingFrom(Date d) {
		return empRepo.findByHireDateGreaterThan(d);
	}

	public Employee save(Employee employee) {

		if (null == employee.getEmp_no()) {
			System.out.println("fecha nacimiento: " + employee.getBirthDate());
			Integer newId = empRepo.findTopBy().getEmp_no() + 1;
			employee.setEmp_no(newId);
		}

		return empRepo.save(employee);
	}

}
