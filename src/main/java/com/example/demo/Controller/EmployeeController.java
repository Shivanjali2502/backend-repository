package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.Employee;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.EmployeeService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class EmployeeController {
	
	
	@Autowired
	private static EmployeeService employeeService;
	
	public  EmployeeController(EmployeeService empseriService)
	{
		this.employeeService = empseriService;
	}
	
	
	@PostMapping
	public Employee CreateEmployeeRecord(@RequestBody Employee employee) {		
		return employeeService.saveAllEmployyeList(employee);
	}
	
	@GetMapping
	public List<Employee> getAllRecordEmployee()
	{
		return employeeService.getAllEmployyeList();
	}
	
	@GetMapping("/{id}")
	public Optional<Employee> GetRecordByid(@PathVariable int id)
	{
		return employeeService.getEmployeeById(id);
	}
	
	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable int id)
	{
		 employeeService.DeleteById(id);
	}
	
	@PutMapping("/{id}")
	
	 public Employee updateEmployeeInfo(@RequestBody Employee emp, @PathVariable int id)
	 {
		return employeeService.UpdateRecord(emp, id);
	}
	
	
	

}
