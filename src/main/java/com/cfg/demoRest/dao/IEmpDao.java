package com.cfg.demoRest.dao;

import com.cfg.demoRest.model.Employee;

import java.util.List;

public interface IEmpDao {
	public Employee createEmployee(Employee emp);
	public List<Employee> getAllEmployee();
	public Employee getEmployee(Long emp_id);
	public List<Employee> deleteEmployee(Long emp_id);
	public Employee updateEmployee(Employee emp);
	
}
