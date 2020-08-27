package com.example.stockexchange.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stock_exchange")
public class StockExchange {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "stock_exchange_name")
    private String stockExchange;
    
	@Column(name = "brief")
    private String brief;
    
	@Column(name = "address")
    private String address;
    
	@Column(name = "remarks")
    private String remarks;


}


    
    
