package com.amu.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amu.dao.BrandDao;
import com.amu.domain.Brand;

@Service
@Transactional
public class BrandService {

	@Autowired
	private BrandDao brandRepository;
	
	public Page<Brand> findAll(Pageable pageable){
		return brandRepository.findAll(pageable);
	}

	public Brand save(Brand brand) {
		Date now =new Date();
		if(brand.getId()==null||brand.getId()<1){
			brand.setCreateTime(now);
			brand.setCreatorId(0L);
			brand.setModifierId(0L);
		}
		brand.setModifyTime(now);
		return brandRepository.save(brand);
	}

	public int update(Brand brand){
		Date now =new Date();
		brand.setModifyTime(now);
		return brandRepository.update(brand.getId(),brand.getName(),brand.getDescription(),brand.getModifyTime());
	}
	
	public Brand findOneById(Long id) {
		return brandRepository.findOne(id);
	}

	public void delete(Long id) {
		brandRepository.delete(id);
	}
	
}
