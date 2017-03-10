package com.amu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Product> findAll(
			/*Pageable pageable*/
			){
		/*Sort sort = new Sort(Direction.DESC, "id");*/
		/*pageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), sort);*/
		/*pageable = new PageRequest(-1, -1, sort);*/
		List<Product> list = productService.findAllOrderByIdDesc();
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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Object findOneById(@PathVariable("id") Long id){
		Product product = productService.findOneById(id);
		if(product == null)
			product = new Product();
		return product;
	}
	
}
