package com.example.companydetails.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockExchangeDto {
	
    private String stockExchange;
    private String brief;
    private String address;
    private String remarks;	

}
