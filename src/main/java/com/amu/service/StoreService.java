package com.amu.service;

import java.util.Date;
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

	/**
	 * 新增store
	 * @author huangsongbo
	 * @param store
	 * @return
	 */
	public Store create(Store store) {
		Date now = new Date();
		store.setCreateTime(now);
		store.setModifyTime(now);
		store.setCreatorId(0L);
		store.setModifierId(0L);
		return storeDao.save(store);
	}

}
