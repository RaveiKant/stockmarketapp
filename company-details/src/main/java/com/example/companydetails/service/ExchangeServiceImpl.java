package com.example.companydetails.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.companydetails.dao.StockExchangeDao;
import com.example.companydetails.dto.StockExchangeDto;
import com.example.companydetails.model.Company;
import com.example.companydetails.model.Ipo;
import com.example.companydetails.model.StockExchange;

@Service
public class ExchangeServiceImpl implements ExchangeService{

	StockExchangeDao stockExchangeDao;
	
	public ExchangeServiceImpl(StockExchangeDao stockExchangeDao) {
		super();
		this.stockExchangeDao = stockExchangeDao;
	}

	@Override
	@Transactional
	public void addNewExchange(StockExchangeDto stockExchangeDto) {
		// TODO Auto-generated method stub
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		StockExchange stockExchange = mapper.map(stockExchangeDto, StockExchange.class);
		stockExchange.setIpoList(new ArrayList<>());
		stockExchangeDao.save(stockExchange);	
		
	}

	@Override
	@Transactional
	public List<StockExchangeDto> findAllExchanges() {
		// TODO Auto-generated method stub

		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		Type listType = new TypeToken<List<StockExchangeDto>>(){}.getType();
        List<StockExchangeDto> postDtoList = mapper.map(stockExchangeDao.findAll(),listType);
        return postDtoList;
		
		//return stockExchangeDao.findAll();
		
	}

	@Override
	public List<Company> findCompanies(String exchangeName) {
		// TODO Auto-generated method stub
		StockExchange exchange = stockExchangeDao.findById(exchangeName).get();
		List<Ipo> ipoList = exchange.getIpoList();
		
		List<Company> companies = new ArrayList<Company>();
		
		for(Ipo ipo : ipoList) {
			companies.add(ipo.getCompany());
		}
		
		return companies;
	}

}
