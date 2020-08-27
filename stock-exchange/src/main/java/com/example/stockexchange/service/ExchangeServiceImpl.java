package com.example.stockexchange.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.stockexchange.dao.StockExchangeDao;
import com.example.stockexchange.model.StockExchange;

@Service
public class ExchangeServiceImpl implements ExchangeService{

	StockExchangeDao stockExchangeDao;
	
	public ExchangeServiceImpl(StockExchangeDao stockExchangeDao) {
		super();
		this.stockExchangeDao = stockExchangeDao;
	}

	@Override
	@Transactional
	public void addNewExchange(StockExchange stockExchange) {
		// TODO Auto-generated method stub
		
		stockExchangeDao.save(stockExchange);	
		
	}

	@Override
	@Transactional
	public List<StockExchange> findAllExchanges() {
		// TODO Auto-generated method stub
		return stockExchangeDao.findAll();
	}

}
