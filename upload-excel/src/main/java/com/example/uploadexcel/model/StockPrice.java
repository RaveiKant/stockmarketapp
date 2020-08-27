package com.example.uploadexcel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock_price")
@Entity
public class StockPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String CompanyCode;
	
	private String StockExchange;
	
	private Double CurrentPrice;
	
	private Date date;
	
	private String time;

}
