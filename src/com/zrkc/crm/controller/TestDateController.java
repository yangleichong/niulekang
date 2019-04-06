package com.zrkc.crm.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zrkc.crm.model.Product;
import com.zrkc.util.DateEditor;

@Controller
@RequestMapping("/testDate")
public class TestDateController {
	
//	@InitBinder  
//    public void initBinder(WebDataBinder binder){  
//        binder.registerCustomEditor(Date.class, new DateEditor());  
//    } 
	
	@RequestMapping("/add")
	public ModelAndView addProduct(Product product){
		System.out.println("Controller:"+product.getCreateTime());
		return null;
		
	}

}
