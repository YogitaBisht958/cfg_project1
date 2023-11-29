package com.cfg.demoRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfg.demoRest.dao.IEmpDao;
import com.cfg.demoRest.model.Employee;

@Service("empService")
public class EmpServiceImpl implements IEmpService{
	
	@Autowired
	IEmpDao empDao;

	@Override
	public Employee createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.createEmployee(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empDao.getAllEmployee();
	}

	@Override
	public Employee getEmployee(Long emp_id) {
		// TODO Auto-generated method stub
		return empDao.getEmployee(emp_id);
	}

	@Override
	public List<Employee> deleteEmployee(Long emp_id) {
		// TODO Auto-generated method stub
		return empDao.deleteEmployee(emp_id);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.updateEmployee(emp);
	}

}
