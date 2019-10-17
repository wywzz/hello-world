package com.cy.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";

	}
	@RequestMapping("log/log_list")
	public String doLogUI() {
		return "sys/log_list";
	}
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
	@RequestMapping("{module}/{page}")
	public String doModuleUI(
			@PathVariable String moduleUI
			) {
		return "sys/"+moduleUI;
		
	}

}