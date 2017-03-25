package com.amu.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public Object create(@ModelAttribute @Valid Brand brand){
		brandService.save(brand);
		return brand;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Object findOneById(@PathVariable("id") Long id){
		Brand brand=brandService.findOneById(id);
		if(brand==null){
			return new ResponseEntity<String>("该品牌未找到", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Brand>(brand, HttpStatus.OK);
	}
	
	@RequestMapping(value="",method=RequestMethod.PUT)
	public Object update(@ModelAttribute @Valid Brand brand){
		return brandService.update(brand);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public Object delete(@PathVariable("id") Long id){
		brandService.delete(id);
		return new ResponseEntity<String>("删除成功", HttpStatus.OK);
	}
	
}
