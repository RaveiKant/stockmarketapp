package com.example.uploadexcel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.uploadexcel.model.StockPrice;

public interface Repo extends JpaRepository<StockPrice, Long>{

}
