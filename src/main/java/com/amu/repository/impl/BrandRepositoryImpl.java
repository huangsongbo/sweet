package com.amu.repository.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.amu.domain.Brand;
import com.amu.repository.BrandRepository;

public class BrandRepositoryImpl extends SimpleJpaRepository<Brand, Serializable> implements BrandRepository{

	public BrandRepositoryImpl(Class<Brand> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
	}
	
}
