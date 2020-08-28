package com.example.companydetails.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;


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
	@Column(name = "stock_exchange_name")
    private String stockExchange;
    
	@Column(name = "brief")
    private String brief;
    
	@Column(name = "address")
    private String address;
    
	@Column(name = "remarks")
    private String remarks;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "stockExchange")
	private List<Ipo> ipoList;


}


    
    
