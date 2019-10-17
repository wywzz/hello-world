package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.service.SysUserService;
@RequestMapping("/user/")
@RestController
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(String username,Integer pageCurrent) {
		PageObject<SysUserDeptVo> data = sysUserService.findPageObjects(username, pageCurrent);
		return new JsonResult(data);
	}
	@RequestMapping(value="doValidById",method = RequestMethod.POST)
	public JsonResult doValidById(Integer id,Integer valid,String modifiedUser) {
		sysUserService.doValidById(id, valid,modifiedUser);
		return new JsonResult("update ok");
	}
}
