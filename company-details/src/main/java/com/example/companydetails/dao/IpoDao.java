package com.example.companydetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.companydetails.model.Ipo;

@Repository
public interface IpoDao extends JpaRepository<Ipo, Integer>{

}
