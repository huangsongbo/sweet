package com.amu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amu.domain.Brand;
import com.amu.repository.BrandRepository;

@Service
@Transactional
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	public Page<Brand> findAll(Pageable pageable){
		return brandRepository.findAll(pageable);
	}
	
}
