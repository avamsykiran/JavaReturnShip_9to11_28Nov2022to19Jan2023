package com.cts.jpahibdemo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="depts")
public class Department {

	@Id
	private Long deptId;
	private String title;
	
	@OneToMany(mappedBy = "dept",cascade = CascadeType.ALL)
	private Set<Employee> employees;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(Long deptId, String title, Set<Employee> employees) {
		super();
		this.deptId = deptId;
		this.title = title;
		this.employees = employees;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", title=" + title + "]";
	}
	
	
}
