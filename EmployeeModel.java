package com.german.student.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class EmployeeModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int manager_id;
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "manager", 
    joinColumns = @JoinColumn(name = "employee_id"), 
    inverseJoinColumns = @JoinColumn(name = "manager_id")
    )
    private List<EmployeeModel> employees;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "employees", 
    joinColumns = @JoinColumn(name = "employee_id"), 
    inverseJoinColumns = @JoinColumn(name = "manager_id")
    )
    private List<EmployeeModel> managers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<EmployeeModel> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeModel> employees) {
		this.employees = employees;
	}

	public List<EmployeeModel> getManagers() {
		return managers;
	}

	public void setManagers(List<EmployeeModel> managers) {
		this.managers = managers;
	}
    
	 public List<EmployeeModel> getEmployee() {
	        return employees;
	    }
	    public void setFriends(List<EmployeeModel> employess) {
	        this.employees = employess;
	    }
	    public List<EmployeeModel> getManager() {
	        return managers;
	    }
	    public void setEmployee(List<EmployeeModel> managers) {
	        this.managers = managers;
	    }
    
}
