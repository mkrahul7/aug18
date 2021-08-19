package com.searchlocation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.searchlocation.dto.Location;
@Controller
public class SearchLocationController {
	@RequestMapping("/searchlocation")
	public String showSearchLocation() {
		return "id";
	}
	@RequestMapping("/search")
	public String findid(@RequestParam("id") long id,ModelMap aa) {
		LocationRestClient a=new LocationRestClient();
		Location ge = a.getlocation(id);
		aa.addAttribute("loc", ge);
		return "searchresult";
	}
	

}
