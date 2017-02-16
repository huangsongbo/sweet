package com.amu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amu.domain.Product;

public interface ProductDao extends JpaRepository<Product, Long>{

}
