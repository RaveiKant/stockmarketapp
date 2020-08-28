package com.example.companydetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.companydetails.dao.CompanyDao;
import com.example.companydetails.dao.SectorDao;
import com.example.companydetails.dto.CompanyDto;
import com.example.companydetails.dto.SectorDto;
import com.example.companydetails.model.Company;
import com.example.companydetails.model.Ipo;
import com.example.companydetails.model.Sector;

@Service
public class CompanyServiceImpl implements CompanyService {

	CompanyDao companyDao;
	SectorDao sectorDao;
	ModelMapper mapper;
	
	public CompanyServiceImpl(CompanyDao companyDao, SectorDao sectorDao, ModelMapper mapper) {
		super();
		this.companyDao = companyDao;
		this.sectorDao = sectorDao;
		this.mapper = mapper;
	}
	
	
	public List<CompanyDto> entity2Dto(List<Company> companies){
		
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<CompanyDto> dtoList = new ArrayList<CompanyDto>();
		for(Company company : companies) {
			
			CompanyDto cdto = mapper.map(company, CompanyDto.class);
			cdto.setSectorId(company.getSector().getSectorId());
			dtoList.add(cdto);			
		}
		
        return dtoList;
		
	}
	
	
	@Override
	@Transactional
	public List<CompanyDto> findAllCompany() {
		// TODO Auto-generated method stub
		
        return this.entity2Dto(companyDao.findAll());

	}
	
	@Override
	@Transactional
	public List<CompanyDto> findCompanyLike(String regex) {
		// TODO Auto-generated method stub		
		return this.entity2Dto(companyDao.findMatching(regex));
	}


	@Override
	@Transactional
	public void addCompany(CompanyDto companyDto) {
		// TODO Auto-generated method stub
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Company company = mapper.map(companyDto, Company.class);
		company.setIpoList(new ArrayList<Ipo>());
		company.setSector(sectorDao.findById(companyDto.getSectorId()).get());
		companyDao.save(company);
		
	}

	@Override
	@Transactional
	public List<CompanyDto> findBySector(Integer sectorId) {
		// TODO Auto-generated method stub
		Sector sector = sectorDao.findById(sectorId).get();
		
		return this.entity2Dto(companyDao.findbySector(sector));
	}


	@Override
	@Transactional
	public CompanyDto deleteCompany(Long CompanyId) {
		// TODO Auto-generated method stub
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Company company = companyDao.findById(CompanyId).get();
		
		CompanyDto cdto = mapper.map(company, CompanyDto.class);
		cdto.setSectorId(company.getSector().getSectorId());
		companyDao.delete(company);
		return cdto;
	}


	@Override
	@Transactional
	public CompanyDto updateCompany(CompanyDto companyDto) {
		// TODO Auto-generated method stub
		Optional<Company> companyOpt = companyDao.findById(companyDto.getCompanyId());
		if(!companyOpt.isPresent()) 
		{
			this.addCompany(companyDto);
			return companyDto;
		}
		
		Company company = companyOpt.get();
		company.setCompanyName(companyDto.getCompanyName());
		company.setCeo(companyDto.getCeo());
		company.setBoardOfDirectors(companyDto.getBoardOfDirectors());
		company.setTurnover(companyDto.getTurnover());
		company.setWriteup(companyDto.getWriteup());
		company.setSector(sectorDao.findById(companyDto.getSectorId()).get());
		
		companyDao.save(company);
		
		return companyDto;
	}


	@Override
	@Transactional
	public void addSector(SectorDto sectorDto) {
		// TODO Auto-generated method stub
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		sectorDao.save(mapper.map(sectorDto, Sector.class));		
	}
	

}
