package com.example.uploadexcel.model;


import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock_price")
public class StockPrice {
	
	private Long CompanyCode;
	
	private String StockExchange;
	
	private Double CurrentPrice;
	
	private LocalDateTime date;
	
	private LocalDateTime time;

}
