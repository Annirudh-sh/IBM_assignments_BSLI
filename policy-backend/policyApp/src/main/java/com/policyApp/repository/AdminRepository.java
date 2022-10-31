package com.policyApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.policyApp.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	@Query
	public Admin findByUserName(final String userName);

}
