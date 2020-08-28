package com.example.companydetails.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ipo_details")
public class Ipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ipoId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "comapny_id")
	private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "exchange_id")
	private StockExchange stockExhange;
	
	private String CompanyCode;
	
	private Double pricePerShare;
	
	private Integer noOfShares;
	
	private Date ipoDate; 
	
	
}
