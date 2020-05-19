package com.uppcl.dashboard.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface EmployeeDetailRepo extends JpaRepository<com.uppcl.dashboard.domain.EmployeeDetail, Long>{

	@Query(value="SELECT EXISTS(SELECT * from `uppclDirectory`.`employee_detail` WHERE mobile=?1)",nativeQuery = true)
	int verifyMobNo(@Valid String mobile);
	
	

}
