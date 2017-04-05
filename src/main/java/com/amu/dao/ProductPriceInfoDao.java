package com.amu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amu.domain.ProductPriceInfo;

public interface ProductPriceInfoDao extends JpaRepository<ProductPriceInfo, Long>{
	
}
