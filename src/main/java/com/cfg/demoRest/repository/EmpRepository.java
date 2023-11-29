package com.cfg.demoRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cfg.demoRest.model.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long>{
	
}
