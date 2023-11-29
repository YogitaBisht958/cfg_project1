package com.cfg.demoRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cfg.demoRest.model.Address;

public interface AddRepository extends JpaRepository<Address, Long>{

}
