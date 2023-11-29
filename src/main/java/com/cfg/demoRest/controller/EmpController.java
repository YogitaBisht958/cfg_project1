package com.cfg.demoRest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cfg.demoRest.model.Employee;
import com.cfg.demoRest.repository.EmpRepository;
import com.cfg.demoRest.service.IEmpService;

@CrossOrigin("http://localhost:4200")  
@RestController
@RequestMapping("/api")
public class EmpController {
	
	@Autowired
	EmpRepository empRepository;
	
	@Autowired
	IEmpService empService;
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		empService.createEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam(required=false) String title){
		List<Employee> emps = empService.getAllEmployee();
		if(emps.isEmpty()) {
			return new ResponseEntity("Sorry ! Employee not found ", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}
	
	@GetMapping("/employees/{emp_id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("emp_id") Long emp_id){
		Employee emp = empService.getEmployee(emp_id);
		if(emp == null) {
			return new ResponseEntity("Sorry! Employee not found", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@PutMapping("/employees")
	public ResponseEntity<Employee> getEmployee(@RequestBody Employee employee){
		empService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{emp_id}")
	public ResponseEntity<List<Employee>> deleteEmployee(@PathVariable("emp_id") Long emp_id){
		List<Employee> emps = empService.deleteEmployee(emp_id);
		if(emps.isEmpty() || emps == null) {
			return new ResponseEntity("Employees not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}
}














