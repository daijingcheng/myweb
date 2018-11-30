package com.iflytek.ossp.bim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bim")
public class CompanyController {
	
@RequestMapping("/test")
 public String test(){
	 return "bim/index";
 }
@RequestMapping("/formtest")
public String formtest(){
	return "bim/formJsp";
}
}
