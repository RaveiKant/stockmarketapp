package com.example.companydetails.service;

import java.util.List;

import com.example.companydetails.dto.StockExchangeDto;
import com.example.companydetails.model.Company;

public interface ExchangeService {
	
	public void addNewExchange(StockExchangeDto stockExchange);
	public List<StockExchangeDto> findAllExchanges();
	public List<Company> findCompanies(String exchangeName);

}
