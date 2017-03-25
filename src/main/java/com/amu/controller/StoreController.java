package com.amu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amu.domain.Store;
import com.amu.service.StoreService;

@Controller
@RequestMapping("/jsp/store")
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/jspList.htm")
	public Object jspList(HttpServletRequest request){
		List<Store> storeList = storeService.findAll();
		request.setAttribute("list", storeList);
		return "/jsp/store/store_list.jsp";
	}
	
}
