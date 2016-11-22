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
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public List<Product> findAll(Pageable pageable){
		List<Product> list=productService.findAll(pageable);
		return list;
	}
	
}
