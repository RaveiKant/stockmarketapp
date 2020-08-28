package com.example.companydetails.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sector")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sector {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sectorId;
	
	private String sectorName;
	
	private String brief;
	
	@OneToMany(mappedBy = "sector")
	private List<Company> companies;

}
