package com.example.stockexchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockexchange.model.StockExchange;

public interface StockExchangeDao extends JpaRepository<StockExchange, Long>{

}

