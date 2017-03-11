package com.amu.service;

import java.util.Date;
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
	private ProductDao productDao;
	
	public List<Product> findAll(Pageable pageable){
		return productDao.findAll(pageable).getContent();
	}

	/**
	 * 保存产品
	 * @param product
	 * @return
	 */
	public Object save(Product product) {
		Date now = new Date();
		product.setCreateTime(now);
		product.setModifyTime(now);
		product.setCreatorId(0L);
		product.setModifierId(0L);
		return productDao.save(product);
	}

	public List<Product> findAllOrderByIdDesc() {
		return productDao.findAllOrderByIdDesc();
	}

	public Product findOneById(Long id) {
		return productDao.findOne(id);
	}

	public Product update(Product product) {
		Date now = new Date();
		product.setModifyTime(now);
		return productDao.save(product);
	}
	
	public void deleteById(Long id){
		productDao.delete(id);
	}
	
}
