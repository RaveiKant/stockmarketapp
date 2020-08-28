package com.example.companydetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.companydetails.model.Sector;

@Repository
public interface SectorDao extends JpaRepository<Sector, Integer>{

}
