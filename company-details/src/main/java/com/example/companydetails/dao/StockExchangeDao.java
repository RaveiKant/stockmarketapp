package com.example.companydetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.companydetails.model.StockExchange;

@Repository
public interface StockExchangeDao extends JpaRepository<StockExchange, String>
{

}

