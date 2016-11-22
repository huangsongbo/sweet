package com.amu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amu.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
