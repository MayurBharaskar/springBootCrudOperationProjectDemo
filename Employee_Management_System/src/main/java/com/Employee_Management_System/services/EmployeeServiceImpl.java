package com.Employee_Management_System.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Employee_Management_System.model.Employee;
import com.Employee_Management_System.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl  implements EmployeeService{

	@Autowired
	private EmployeeRepository emplyRepository;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return emplyRepository.findAll();
	}


	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.emplyRepository.save(employee);
		
	}


	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> optional =emplyRepository.findById(id);
		Employee employee = null;
		
		if(optional.isPresent()) {
			employee= optional.get();
			
		}
		else {
			
			throw  new RuntimeException("id not found ::   "+id);
		}
				
		return employee;
	}


	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		
		this.emplyRepository.deleteById(id);
		
	}


	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		
		Pageable pageable = PageRequest.of(pageNo -1 , pageSize);
		
		
		return this.emplyRepository.findAll(pageable);
	}

	
	
	
	
	
	
	
	}


