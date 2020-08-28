package com.example.companydetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectorDto {
	
	private Integer sectorId;
	private String sectorName;
	private String brief;

}
