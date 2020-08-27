package com.example.stockexchange.service;

import java.util.List;

import com.example.stockexchange.model.StockExchange;

public interface ExchangeService {
	
	public void addNewExchange(StockExchange stockExchange);
	public List<StockExchange> findAllExchanges();

}
