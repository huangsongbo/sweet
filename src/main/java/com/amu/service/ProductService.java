package com.amu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amu.dao.ProductDao;
import com.amu.domain.Product;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductDao productRepository;
	
	public List<Product> findAll(Pageable pageable){
		return productRepository.findAll(pageable).getContent();
	}
	
}
