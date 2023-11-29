package com.cfg.demoRest.service;

import java.util.List;

import com.cfg.demoRest.model.Employee;

public interface IEmpService {
	public Employee createEmployee(Employee emp);
	public List<Employee> getAllEmployee();
	public Employee getEmployee(Long emp_id);
	public List<Employee> deleteEmployee(Long emp_id);
	public Employee updateEmployee(Employee emp);
	
}
