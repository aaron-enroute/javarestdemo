package com.enroute.ws.javarestdemo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer emp_no;

	@Column(name = "birth_date", nullable = false)
	private Date birthDate;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "hire_date", nullable = false)
	private Date hireDate;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	// @JoinColumn(name = "emp_no", referencedColumnName = "emp_no")
	private List<Titles> titles;

}
