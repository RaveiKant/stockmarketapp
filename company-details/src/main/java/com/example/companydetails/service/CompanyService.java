package com.example.companydetails.service;

import java.util.List;

import com.example.companydetails.dto.CompanyDto;
import com.example.companydetails.dto.SectorDto;

public interface CompanyService {
	
	public void addCompany(CompanyDto companyDto);
	public List<CompanyDto> findAllCompany();
	public List<CompanyDto> findCompanyLike(String regex);
	public CompanyDto deleteCompany(Long companyId);
	public CompanyDto updateCompany(CompanyDto companyDto);
	
	public List<CompanyDto> findBySector(Integer sectorId);
	public void addSector(SectorDto sectorDto);

}
