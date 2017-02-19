package com.amu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amu.domain.Product;
import com.amu.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductRest {

	@Autowired
	private ProductService productService;
	
	/**
	 * 查询产品list
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Product> findAll(Pageable pageable){
		List<Product> list = productService.findAll(pageable);
		return list;
	}
	
	/**
	 * 保存产品
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Object save(Product product){
		return productService.save(product);
	}
	
}
