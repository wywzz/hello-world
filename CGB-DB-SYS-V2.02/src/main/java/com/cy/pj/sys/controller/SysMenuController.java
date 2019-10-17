package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;

@RequestMapping("/menu/")
@RestController
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;
	@PostMapping("doSaveObject")
public JsonResult doSaveObject(SysMenu entity) {
	sysMenuService.saveObject(entity);
	return new JsonResult("save ok");
}
	
	@RequestMapping("doDeleteobject")
	public JsonResult doDeleteObject(Integer id) {
		sysMenuService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	public JsonResult doFindObjects() {
		return new JsonResult(sysMenuService.findObjects());
	}
}
