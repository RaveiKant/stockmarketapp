package com.example.companydetails.service;

import java.util.List;

import com.example.companydetails.dto.IpoDto;

public interface IpoService {
	
	public List<IpoDto> findAllIpo();
	public void AddNewIpo(IpoDto ipoDto);
	public IpoDto findIpobyId(Integer ipoId);
	public IpoDto updateIpo(IpoDto ipoDto);

}
