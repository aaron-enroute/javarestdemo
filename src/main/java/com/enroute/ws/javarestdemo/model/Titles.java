package com.enroute.ws.javarestdemo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "titles")
public class Titles {
	@Id
	@GeneratedValue
	private int emp_no;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="emp_no", nullable=false, insertable=false, updatable=false)
	private Employee employee;
	
	
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	private String title;
	private Date fromDate;
	private Date toDate;
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	@Override
	public String toString() {
		return "Titles [emp_no=" + emp_no + ", title=" + title + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
	
	public Titles(int emp_no, String title, Date fromDate, Date toDate) {
		super();
		this.emp_no = emp_no;
		this.title = title;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public Titles() {
		super();
	}
	
	
}

