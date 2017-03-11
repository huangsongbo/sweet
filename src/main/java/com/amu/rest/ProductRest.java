package com.amu.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amu.domain.Brand;
import com.amu.domain.Product;
import com.amu.domain.DTO.ProductDTO;
import com.amu.service.BrandService;
import com.amu.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductRest {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private BrandService brandService;
	
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
	public Object save(@Valid Product product){
		return productService.save(product);
	}
	
	/**
	 * 根据id查找产品信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Object findOneById(@PathVariable("id") Long id){
		Product product = productService.findOneById(id);
		if(product == null)
			product = new Product();
		return product;
	}
	
	/**
	 * 修改/更新产品
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Object update(@Valid ProductDTO productDTO){
		Product product = productService.findOneById(productDTO.getId());
		if(product == null)
			return new ResponseEntity<String>("该产品未找到", HttpStatus.NOT_FOUND);
		product.setName(productDTO.getName());
		product.setHkd(productDTO.getHkd());
		product.setDescription(productDTO.getDescription());
		// 品牌 ->start
		if(productDTO.getBrandId() != null && productDTO.getBrandId() > 0){
			Brand brand = brandService.findOneById(productDTO.getBrandId());
			if(brand != null){
				product.setBrand(brand);
			}
		}else{
			product.setBrand(null);
		}

		// 品牌 ->end
		productService.update(product);
		return new ResponseEntity<String>("success", HttpStatus.OK);
		/*return productService.update(product);*/
	}
	
}