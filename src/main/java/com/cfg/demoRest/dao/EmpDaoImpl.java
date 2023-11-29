package com.cfg.demoRest.dao;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cfg.demoRest.model.Address;
import com.cfg.demoRest.model.Employee;
import com.cfg.demoRest.repository.AddRepository;
import com.cfg.demoRest.repository.EmpRepository;

@Repository("empDao")
public class EmpDaoImpl implements IEmpDao{
	
	@Autowired
	EmpRepository empRepository;
	
	@Autowired
	AddRepository addRepository;


	@Override
	public Employee createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		if(emp != null) {
			Address address = emp.getAddress();
			Address add = new Address(address.getAdd_id(), address.getCity(), address.getStreet_no(), address.getCountry());
			Address add1 = addRepository.save(add);
			emp.setAddress(add1);
			return empRepository.save(new Employee(emp.getEmp_id(), emp.getFirstName(), emp.getLastName(), emp.getGender(), 
					emp.getAddress()));
		}
		
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empRepository.findAll();
	}

	@Override
	public Employee getEmployee(Long emp_id) {
		// TODO Auto-generated method stub
		Optional<Employee> empData = empRepository.findById(emp_id);
		if(empData.isPresent()) {
			return empData.get();
		}
		
		return null;
	}

	@Override
	public List<Employee> deleteEmployee(Long emp_id) {
		// TODO Auto-generated method stub
		Optional<Employee> empData = empRepository.findById(emp_id);
		if(empData.isPresent()) {
			empRepository.deleteById(emp_id);
			List<Employee> emps = empRepository.findAll();
			if(emps.isEmpty() || emps == null)	return null;
			else 
				return emps;
		}
		
		return null;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Long emp_id = emp.getEmp_id();
		Optional<Employee> empData = empRepository.findById(emp_id);
		if(empData.isPresent()) {
				Employee emp2 = empData.get();
//				emp2.setFirstName(emp.getFirstName());
//				emp2.setLastName(emp.getLastName());
//				emp2.setGender(emp.getGender());
				
				Address aemp = emp.getAddress(); //user
				Address aemp2 = emp2.getAddress(); //db
//				if(aemp.getCity() != aemp2.getCity() || aemp.getStreet_no() != aemp2.getStreet_no() || 
//						aemp.getCountry() != aemp2.getCountry()) {
					System.out.println("Inside address update..." + aemp2.getAdd_id());
					aemp2.setCity(aemp.getCity());
					aemp2.setStreet_no(aemp.getStreet_no());
					aemp2.setCountry(aemp.getCountry());
					
//					System.out.println(aemp2.getCity());	
//				}	
//				
				return empRepository.save(emp2);
			}
		return null;
	}

}
