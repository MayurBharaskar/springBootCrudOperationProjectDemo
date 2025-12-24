package com.Employee_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Employee_Management_System.model.Employee;

import com.Employee_Management_System.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		
		
		return findpagenated(1, model);
	}
	
	
	@GetMapping("/addnew")
	public String addnew(Model model) {
		
		Employee employee =new Employee();
		model.addAttribute("employee", employee);
		
		return "new_employee";
		
			}
	
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeService.saveEmployee(employee);
		
		return "redirect:/";
		
		
	}
	
	@GetMapping("/showformforupdate/{id}")
	public String showformforupdate(@PathVariable(value = "id") Long id , Model model) {
		
		Employee employee = employeeService.getEmployeeById(id);
		
		model.addAttribute("employee", employee);
		
		return "update_employee";
	}
	
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Long id) {
		
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
		
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findpagenated(@PathVariable(value = "pageNo") int pageNo , Model model) {
		
		int pageSize =5;
		
		Page<Employee> page =employeeService.findPaginated(pageNo, pageSize);
		List<Employee> listEmployee=page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("totalItem", page.getTotalElements());
		model.addAttribute("listEmployee", listEmployee);
		
		return "index";
		
		
	}
	
	
	
}
