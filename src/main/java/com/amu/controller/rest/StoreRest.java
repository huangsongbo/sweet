package com.amu.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amu.domain.Store;
import com.amu.service.StoreService;

@RestController
@RequestMapping("/store")
public class StoreRest {

	@Autowired
	private StoreService storeService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Object add(@Valid Store store){
		storeService.create(store);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
}
