package com.amu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.amu.SweetApplication;
import com.amu.domain.Brand;

/**
 * 测试类(测试brandService中的方法)
 * @author huangsongbo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SweetApplication.class)
@WebAppConfiguration
public class BrandServiceTest {

	@Autowired
	BrandService brandService;
	
	@Test
	public void saveCustomTest(){
		/*System.out.println("saveCustomTest");*/
		Brand brand = new Brand();
		brand.setId(7L);
		brand.setName("测试品牌");
		int num = brandService.saveCustom(brand);
		System.out.println(num);
	}
	
}
