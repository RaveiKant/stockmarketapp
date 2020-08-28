package com.example.companydetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
	
	private Long CompanyId;
	private String companyName;
	private Long turnover;
	private String ceo;
	private String boardOfDirectors;
	private Integer sectorId;
	private String writeup;	

}
