package com.amu.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productPriceInfo")
public class ProductPriceInfoRest {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Object findOneById(Long id){
		return null;
	}
	
	public Object findAllByProductId(){
		return null;
	}
	
}
