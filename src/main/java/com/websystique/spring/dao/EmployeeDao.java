package com.websystique.spring.dao;

import java.util.List;

import com.websystique.spring.model.Employee;

public interface EmployeeDao {

	void saveEmployee(Employee employee);
	
	List<Employee> findAllEmployees();
	
	void deleteEmployeeBySsn(String ssn);
	
	Employee findBySsn(String ssn);

	Employee findById(Integer id);
	
	void updateEmployee(Employee employee);
}
