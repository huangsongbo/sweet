package com.amu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amu.domain.Brand;
import com.amu.service.BrandService;

@RestController
@RequestMapping("/brands")
public class BrandRest {

	@Autowired
	private BrandService brandService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public List<Brand> findAll(Pageable pageable){
		return brandService.findAll(pageable).getContent();
	}
	
}
