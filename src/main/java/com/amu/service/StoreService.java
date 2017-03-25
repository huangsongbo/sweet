package com.amu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amu.dao.StoreDao;
import com.amu.domain.Store;

@Service
@Transactional
public class StoreService {

	@Autowired
	private StoreDao storeDao;
	
	public List<Store> findAll() {
		return storeDao.findAll();
	}

}
