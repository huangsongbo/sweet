package com.amu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amu.dao.custom.ProductDaoCustom;
import com.amu.domain.Product;

public interface ProductDao extends JpaRepository<Product, Long>, ProductDaoCustom{

	@Query("select p from Product p order by p.id desc")
	List<Product> findAllOrderByIdDesc();

}
