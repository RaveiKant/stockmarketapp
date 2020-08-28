package com.example.companydetails.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_id")
	private Long CompanyId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "turnover")
	private Long turnover;
	
	@Column(name = "ceo_name")
	private String ceo;
	
	@Column(name = "directors")
	private String boardOfDirectors;
	
	@ManyToOne
	@JoinColumn(name = "sector_id")
	private Sector sector;
	
	@Column(name = "brief_description")
	private String writeup;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "comapny")
	private List<Ipo> ipoList;
	
	

}
