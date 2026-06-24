package com.cognizant.loan;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LoanController {
	@GetMapping("/loans/{number}")
	public Map<String,Object>getLoan(@PathVariable String number){
		Map<String,Object> l=new HashMap<>();
		l.put("number",number);
		l.put("type","car");
		l.put("loan",400000);
		l.put("emi",3258);
		l.put("tenure",18);
		return l;
		
	}
}
