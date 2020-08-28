package com.example.companydetails.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.companydetails.model.Company;
import com.example.companydetails.model.Sector;

@Repository
public interface CompanyDao extends JpaRepository<Company, Long> {
	
	@Query(value = "SELECT c FROM Company c WHERE c.companyName LIKE CONCAT('%',:regex,'%') ")
    List<Company> findMatching(String regex);
	
	@Query(value = "SELECT c FROM Company c, Sector s WHERE c.sector = s ")
	List<Company> findbySector(Sector sector);

}
