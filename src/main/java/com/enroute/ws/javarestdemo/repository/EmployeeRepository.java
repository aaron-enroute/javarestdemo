package com.enroute.ws.javarestdemo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enroute.ws.javarestdemo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//findTopByCountryOrderByRetVersionDesc
	Employee findTopBy();
	// findByStartGreaterThan

	Iterable<Employee> findByHireDateGreaterThan(Date d);
}
