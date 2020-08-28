package com.example.companydetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.companydetails.dao.CompanyDao;
import com.example.companydetails.dao.IpoDao;
import com.example.companydetails.dao.StockExchangeDao;
import com.example.companydetails.dto.IpoDto;
import com.example.companydetails.model.Ipo;

@Service
public class IpoServiceImpl implements IpoService{
	
	IpoDao ipoDao;
	CompanyDao companyDao;
	StockExchangeDao stockExchangeDao;
	ModelMapper mapper;
	
	public IpoServiceImpl(IpoDao ipoDao, CompanyDao companyDao, StockExchangeDao stockExchangeDao, ModelMapper mapper) {
		super();
		this.ipoDao = ipoDao;
		this.companyDao = companyDao;
		this.stockExchangeDao = stockExchangeDao;
		this.mapper = mapper;
	}

	@Override
	@Transactional
	public List<IpoDto> findAllIpo() {
		// TODO Auto-generated method stub
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<IpoDto> dtoList = new ArrayList<IpoDto>();
		List<Ipo> ipoList = ipoDao.findAll();
		
		for(Ipo ipo : ipoList) {
			IpoDto ipoDto = mapper.map(ipo, IpoDto.class);
			ipoDto.setCompanyId(ipo.getCompany().getCompanyId());
			ipoDto.setStockExhange(ipo.getStockExhange().getStockExchange());
			
			dtoList.add(ipoDto);			
		}
		
		return dtoList;
	}

	@Override
	@Transactional
	public void AddNewIpo(IpoDto ipoDto) {
		// TODO Auto-generated method stub
		
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Ipo ipo = mapper.map(ipoDto, Ipo.class);
		ipo.setCompany(companyDao.findById(ipoDto.getCompanyId()).get());
		ipo.setStockExhange(stockExchangeDao.findById(ipoDto.getStockExhange()).get());		
		
		ipoDao.save(ipo);
		
	}

	@Override
	public IpoDto findIpobyId(Integer ipoId) {
		// TODO Auto-generated method stub
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Ipo ipo = ipoDao.findById(ipoId).get();
		IpoDto ipoDto = mapper.map(ipo, IpoDto.class);
		ipoDto.setCompanyId(ipo.getCompany().getCompanyId());
		ipoDto.setStockExhange(ipo.getStockExhange().getStockExchange());
		return ipoDto;
	}

	@Override
	public IpoDto updateIpo(IpoDto ipoDto) {
		// TODO Auto-generated method stub
		Optional<Ipo> ipoOp = ipoDao.findById(ipoDto.getIpoId());
		if(!ipoOp.isPresent()) {
			this.AddNewIpo(ipoDto);
			return ipoDto;
		}
		
		Ipo ipo = ipoOp.get();
		
		ipo.setCompany(companyDao.findById(ipoDto.getCompanyId()).get());
		ipo.setStockExhange(stockExchangeDao.findById(ipoDto.getStockExhange()).get());
		ipo.setCompanyCode(ipoDto.getCompanyCode());
		ipo.setIpoDate(ipoDto.getIpoDate());
		ipo.setNoOfShares(ipoDto.getNoOfShares());
		ipo.setPricePerShare(ipoDto.getPricePerShare());
		
		
		ipoDao.save(ipo);

		
		return ipoDto;
	}

}
