package com.amu.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amu.domain.Product;
import com.amu.domain.ProductPriceInfo;
import com.amu.domain.Store;
import com.amu.service.ProductService;
import com.amu.service.StoreService;

@Controller
@RequestMapping("/jsp/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/productStoreList")
	public String productStoreList(HttpServletRequest request){
		List<Product> productList = productService.findAllOrderByIdDesc();
		// 动态得到标题 ->start
		List<Store> storeList = storeService.findAll();
		// 储存标题
		List<String> storeNameList = new ArrayList<String>();
		// storeId : index
		Map<Long, Integer> storeIdForIndexMap = new HashMap<Long, Integer>();
		Integer index = 0;
		for(Store store : storeList){
			storeNameList.add(store.getName());
			storeIdForIndexMap.put(store.getId(), index);
			index ++;
		}
		// 动态得到标题 ->end
		// 动态得到内容 ->start
		List<BigDecimal> priceList = new ArrayList<BigDecimal>();
		int size = storeNameList.size();
		for(int i = 0; i < size; i ++){
			priceList.add(null);
		}
		// 遍历每个产品,得到门店对应价格list
		for(Product product : productList){
			List<BigDecimal> priceListNew = new ArrayList<BigDecimal>();
			priceListNew.addAll(priceList);
			List<ProductPriceInfo> productPriceInfoList = product.getProductPriceInfoList();
			for(ProductPriceInfo productPriceInfo : productPriceInfoList){
				if(storeIdForIndexMap.containsKey(productPriceInfo.getStoreId())){
					priceListNew.set(storeIdForIndexMap.get(productPriceInfo.getStoreId()), productPriceInfo.getPrice());
				}
			}
			product.setPriceList(priceListNew);
		}
		// 动态得到内容 ->end
		request.setAttribute("storeNameList", storeNameList);
		request.setAttribute("list", productList);
		return "/jsp/product/product_list_store.jsp";
	}
	
}
