package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.Employee;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	@Autowired
	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository emprep)
	{
		this.employeeRepository = emprep;
	}
	
	
	public List<Employee> getAllEmployyeList()
	{
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> getEmployeeById(int id)
	{
		return employeeRepository.findById(id);
	}
	
	public Employee saveAllEmployyeList(Employee emp)
	{
		return employeeRepository.save(emp);
	}
	
	public void DeleteById(int id)
	{
	    if(!employeeRepository.existsById(id))
	    {
	        throw new RuntimeException("Employee not found");
	    }

	    employeeRepository.deleteById(id);
	}
	
	public Employee UpdateRecord(Employee emp,int id)
	{
		Employee existemp =  employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
		existemp.setName(emp.getName());
		existemp.setEmail(emp.getEmail());
		existemp.setDepartment(emp.getDepartment());
		
		return employeeRepository.save(existemp);
	}

}
