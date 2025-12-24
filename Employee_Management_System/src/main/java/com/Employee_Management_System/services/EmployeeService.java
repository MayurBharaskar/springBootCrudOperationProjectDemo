package com.Employee_Management_System.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Employee_Management_System.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	Page<Employee> findPaginated(int pageNo, int pageSize);

}
