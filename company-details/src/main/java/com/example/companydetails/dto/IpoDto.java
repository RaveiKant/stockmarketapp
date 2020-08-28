package com.example.companydetails.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IpoDto {
	
	private Integer ipoId;
	private Long companyId;
	private String stockExhange;
	private String CompanyCode;
	private Double pricePerShare;
	private Integer noOfShares;
	private Date ipoDate; 
	

}
